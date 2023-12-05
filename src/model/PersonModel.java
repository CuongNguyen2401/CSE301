package model;

import java.sql.Date;

public class PersonModel {

    private String ssn;
    private String name;
    private Date dob;
    private String street;
    private String city;
    private String province;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "PersonModel{" + "ssn=" + ssn + ", name=" + name + ", dob=" + dob + ", street=" + street + ", city=" + city + ", province=" + province + '}';
    }

    
    
    
}
