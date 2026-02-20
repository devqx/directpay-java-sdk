package Examples;

import Config.ApiConfig;
import DTOs.ChargeRequestDTO;
import DTOs.ChargeResponseDTO;
import Services.AiropayDirectCharge;
import Services.EncryptionService;

import java.util.Date;

public class TestCharge {

    public static void main(String[] args) throws Exception {
        byte[] iv = EncryptionService.generateAndPrintIV();
        String encryptionKey = ApiConfig.getProperty("charge_api_encryption_key");
        ChargeRequestDTO chargeRequestDTO = new ChargeRequestDTO();
        chargeRequestDTO
                .setAmount("10.50")
                .setAddress("Los Angeles")
                .setCurrency("USD")
                .setEmail("test@email.com")
                .setCity("Gotham")
                .setState("Colorado")
                .setCountry("US")
                .setCountry_dial_code("41")
                .setFirst_name("John")
                .setLast_name("Doe")
                .setMid("DC10967")
                .setMiddle_name("Preach")
                .setPhone_number("123456789")
                .setPostal_code("1234")
                .setNotify_url("https://notify.yourapi.com")
                .setRedirect_url("https://charge.airopay.com")
                .setReference("AIROPAY"+new Date().getTime())
                .setCvv(EncryptionService.encrypt("123", encryptionKey, iv))
                .setCard_number(EncryptionService.encrypt("4441111155171162", encryptionKey, iv))
                .setExpiry_month(EncryptionService.encrypt("10", encryptionKey, iv))
                .setExpiry_year(EncryptionService.encrypt("28", encryptionKey, iv));

       ChargeResponseDTO chargeResponseDTO = AiropayDirectCharge.charge(chargeRequestDTO);
        System.out.println(chargeResponseDTO.getStatus());
        System.out.println(chargeResponseDTO.getError());
        System.out.println(chargeResponseDTO.getMessage());
        System.out.println(chargeResponseDTO.getData());
    }



}
