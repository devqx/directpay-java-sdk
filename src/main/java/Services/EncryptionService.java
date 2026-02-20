package Services;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionService {

    public static String encrypt(String plainText, String key, byte[] iv) throws Exception {

        // Prepare key (PHP pads/truncates to 32 bytes for AES-256)
        byte[] keyBytes = Arrays.copyOf(key.getBytes(StandardCharsets.UTF_8), 32);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // Combine IV + ":" + ciphertext
        byte[] combined = new byte[iv.length + 1 + cipherText.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        combined[iv.length] = ':'; // separator
        System.arraycopy(cipherText, 0, combined, iv.length + 1, cipherText.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    public static String decrypt(String base64Input, String key) throws Exception {

        byte[] combined = Base64.getDecoder().decode(base64Input);

        // Find the ':' separator (same one we added during encryption)
        int colonIndex = -1;
        for (int i = 0; i < combined.length; i++) {
            if (combined[i] == ':') {
                colonIndex = i;
                break;
            }
        }

        if (colonIndex <= 0) {
            throw new IllegalArgumentException("Invalid encrypted data format");
        }

        // Extract IV and CipherText
        byte[] iv = Arrays.copyOfRange(combined, 0, colonIndex);
        byte[] cipherText = Arrays.copyOfRange(combined, colonIndex + 1, combined.length);

        // Prepare key exactly like encryption
        byte[] keyBytes = Arrays.copyOf(key.getBytes(StandardCharsets.UTF_8), 32);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }



    public static byte[] generateAndPrintIV() {
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }
}