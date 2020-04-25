package com.example.loginpage;

public class AvailableOrderHelper {

    private String dish1,dish2,name_customer,name_restaurant,quantity1,quantity2,amount,phone_no;

    public AvailableOrderHelper() {

    }

    public AvailableOrderHelper(String dish1, String dish2, String name_customer, String name_restaurant, String quantity1, String quantity2, String amount, String phone_no) {
        this.dish1 = dish1;
        this.dish2 = dish2;
        this.name_customer = name_customer;
        this.name_restaurant = name_restaurant;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.amount = amount;
        this.phone_no = phone_no;
    }

    public String getDish1() {
        return dish1;
    }

    public void setDish1(String dish1) {
        this.dish1 = dish1;
    }

    public String getDish2() {
        return dish2;
    }

    public void setDish2(String dish2) {
        this.dish2 = dish2;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getName_restaurant() {
        return name_restaurant;
    }

    public void setName_restaurant(String name_restaurant) {
        this.name_restaurant = name_restaurant;
    }

    public String getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(String quantity1) {
        this.quantity1 = quantity1;
    }

    public String getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(String quantity2) {
        this.quantity2 = quantity2;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
