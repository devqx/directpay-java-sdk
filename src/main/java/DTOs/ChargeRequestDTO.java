package DTOs;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ChargeRequestDTO {
        private String first_name;
        private String last_name;
        private String middle_name;
        private String email;
        private String reference;
        private String phone_number;
        private String address;
        private String city;
        private String state;
        private String postal_code;
        private String country_dial_code;
        private String country;
        private String redirect_url;
        private String notify_url;
        private String mid;
        private String card_number;
        private String expiry_year;
        private String expiry_month;
        private String cvv;
        private String currency;
        private String amount;
        private ChargeRequestDTO data;


    public ChargeRequestDTO setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public ChargeRequestDTO setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public ChargeRequestDTO setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
        return this;
    }

    public ChargeRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public ChargeRequestDTO setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public ChargeRequestDTO setPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    public ChargeRequestDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public ChargeRequestDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public ChargeRequestDTO setState(String state) {
        this.state = state;
        return this;
    }

    public ChargeRequestDTO setPostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }

    public ChargeRequestDTO setCountry_dial_code(String country_dial_code) {
        this.country_dial_code = country_dial_code;
        return this;
    }

    public ChargeRequestDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public ChargeRequestDTO setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
        return this;
    }

    public ChargeRequestDTO setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public ChargeRequestDTO setMid(String mid) {
        this.mid = mid;
        return this;
    }

    public ChargeRequestDTO setCard_number(String card_number) {
        this.card_number = card_number;
        return this;
    }

    public ChargeRequestDTO setExpiry_year(String expiry_year) {
        this.expiry_year = expiry_year;
        return this;
    }

    public ChargeRequestDTO setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
        return this;
    }

    public ChargeRequestDTO setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public ChargeRequestDTO setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ChargeRequestDTO setAmount(String amount) {
        this.amount = amount;
        return this;
    }


    public String getExpiry_month() {
        return expiry_month;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getEmail() {
        return email;
    }

    public String getReference() {
        return reference;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry_dial_code() {
        return country_dial_code;
    }

    public String getCountry() {
        return country;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public String getMid() {
        return mid;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getExpiry_year() {
        return expiry_year;
    }

    public ChargeRequestDTO getData() {
        return data;
    }

    public void setData(ChargeRequestDTO data) {
        this.data = data;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAmount() {
        return amount;
    }

    public String toJson() throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, String> dtoMap = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            dtoMap.put(field.getName(), (String) field.get(this));
        }

        HashMap<String, HashMap<String, String>> request = new HashMap<>();
        request.put("data", dtoMap);
        String data = new Gson().toJson(request);
        System.out.println(data);
        return data;
    }


}

