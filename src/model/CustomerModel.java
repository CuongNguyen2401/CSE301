package model;

public class CustomerModel extends PersonModel {

    private String customer_id;
    private float credit_rating;

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public float getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(float credit_rating) {
        this.credit_rating = credit_rating;
    }

    @Override
    public String toString() {
        return "CustomerModel{"
                + "customer_id='" + customer_id + '\''
                + ", credit_rating=" + credit_rating + '\''
                + ", ssn='" + getSsn() + '\''
                + ", name='" + getName() + '\''
                + ", dob=" + getDob() + '\''
                + ", street='" + getStreet() + '\''
                + ", city='" + getCity() + '\'' 
                + ", province='" + getProvince() + '\''
                + '}';
    }

}
