package Services;

import Config.ApiConfig;
import DTOs.ChargeRequestDTO;
import DTOs.ChargeResponseDTO;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class AiropayDirectCharge {

    public static final MediaType JSON = okhttp3.MediaType.parse("application/json; charset=utf-8");
    public static ChargeResponseDTO charge(ChargeRequestDTO chargeRequestDTO) throws IOException, NoSuchFieldException, IllegalAccessException {
        RequestBody requestBody = RequestBody
                .create(chargeRequestDTO.toJson(), JSON);

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .url(ApiConfig.getProperty("charge_api_base_url") + ApiConfig.getProperty("charge_api_charge_endpoint"))
                .post(requestBody)
                .build();

        OkHttpClient charge_api_client = new OkHttpClient.Builder().build();
        Response response = charge_api_client.newCall(request).execute();
        assert response.body() != null;
        String responseBody = response.body().string();
        System.out.println(responseBody);
        return new Gson().fromJson(responseBody, ChargeResponseDTO.class);
    }


}




