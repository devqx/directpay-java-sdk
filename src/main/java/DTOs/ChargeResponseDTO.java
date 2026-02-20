package DTOs;

import java.util.HashMap;

public class ChargeResponseDTO {
    private String status;
    private String message;
    private Object error;
    private HashMap<String,ChargesResponseDataDTO> data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getError() {
        return error;
    }

    public HashMap<String, ChargesResponseDataDTO> getData() {
        return data;
    }
}


