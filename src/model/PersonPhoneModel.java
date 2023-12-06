package model;

/**
 *
 * @author ACER
 */
public class PersonPhoneModel {
    private String ssn ;
    private String phone;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonPhoneModel{" + "ssn=" + ssn + ", phone=" + phone + '}';
    }
    
}
