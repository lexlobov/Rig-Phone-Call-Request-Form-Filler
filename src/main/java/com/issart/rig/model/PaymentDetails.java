package com.issart.rig.model;

public class PaymentDetails {

    private final String email = "abc@maik.com";
    private final String cardNumber = "4111111111111111";
    private final String month = "12";
    private final String year = "28";
    private final String cvc = "123";
    private final String nameOnCard = "John Williams";

    public String getEmail() {
        return email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCvc() {
        return cvc;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }
}
