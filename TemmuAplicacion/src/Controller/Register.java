package Controller;

import java.util.Scanner;

import View.RgCustomervw;

/**
 * This class receives the data entered by the user and validates some
 * conditions to keep the data or delete it.
 */
public class Register {

    /**
     * @param name     Will store the username
     * @param age      Will store the age of user
     * @param numphon  Will store the phone number of user
     * @param country  Will store the country of user
     * @param resiadd  Will store the residence address of user
     * @param email    Will store the email of user
     * @param password Will store the password of user
     * @param exp      Will store the experience of user
     */
    public String name;
    public Integer age;
    public Long numphon;
    public String country;
    public String resiadd;
    public String email;
    public String password;
    public String exp;
    Scanner inputs = new Scanner(System.in);

    /**
     * Constructor for Register class that receives string values for each field,
     * processes them through validation methods, and assigns them to the attributes.
     *
     * @param name     User's name
     * @param age      User's age (as string)
     * @param numphon  User's phone number (as string)
     * @param country  User's country
     * @param resiadd  User's residence address
     * @param email    User's email
     * @param password User's password
     * @param exp      User's work experience
     */
    public Register(String name, String age, String numphon, String country, String resiadd, String email, String password, String exp) {
        getname(name);
        getage(age);
        getnumberofphone(numphon);
        getcountry(country);
        getresaddr(resiadd);
        getemail(email);
        getpassword(password);
        getexp(exp);
        setname();
        setage();
        setnumberofphone();
        setcountry();
        setresadd();
        setemail();
        setpassword();
        setexp();
    }

    /**
     * Validates the name entered. If the name is shorter than 3 characters,
     * it sets it to null.
     *
     * @param name User's name input
     */
    private void getname(String name) {
        try {
            this.name = name;
            if (this.name.length() < 3) {
                this.name = null;
            }
        } catch (Exception e) {
            this.name = null;
        }
    }

    /**
     * Validates the age entered. If the age is less than 18 or negative,
     * it sets it to null.
     *
     * @param age User's age input as string
     */
    private void getage(String age) {
        try {
            this.age = Integer.parseInt(age);
            if (this.age < 18 || this.age < 0) {
                this.age = null;
            }
        } catch (Exception e) {
            this.age = null;
        }
    }

    /**
     * Validates the phone number. If the number does not have exactly 10 digits,
     * it sets it to null.
     *
     * @param numphon Phone number as string
     */
    private void getnumberofphone(String numphon) {
        try {
            this.numphon = Long.parseLong(numphon);
            String numStr = Long.toString(this.numphon);
            if (numStr.length() != 10) {
                this.numphon = null;
            }
        } catch (Exception e) {
            this.numphon = null;
        }
    }

    /**
     * Stores the country entered.
     *
     * @param country User's country
     */
    private void getcountry(String country) {
        try {
            this.country = country;
        } catch (Exception e) {
            this.country = null;
        }
    }

    /**
     * Stores the residence address entered.
     *
     * @param resiadd User's residence address
     */
    private void getresaddr(String resiadd) {
        try {
            this.resiadd = resiadd;
        } catch (Exception e) {
            this.resiadd = null;
        }
    }

    /**
     * Validates the email. If it does not contain '@gmail.com' or '@hotmail.com',
     * it sets it to null.
     *
     * @param email User's email input
     */
    private void getemail(String email) {
        try {
            this.email = email;
            if (this.email.contains("@gmail.com") || this.email.contains("@hotmail.com")) {
                // Valid email
            } else {
                this.email = null;
            }
        } catch (Exception e) {
            this.email = null;
        }
    }

    /**
     * Validates the password. If the length is less than 6 characters,
     * it sets it to null.
     *
     * @param password User's password input
     */
    private void getpassword(String password) {
        try {
            this.password = password;
            if (this.password.length() < 6) {
                this.password = null;
            }
        } catch (Exception e) {
            this.password = null;
        }
    }

    /**
     * Stores the work experience entered.
     *
     * @param exp User's work experience
     */
    private void getexp(String exp) {
        try {
            this.exp = exp;
        } catch (Exception e) {
            this.exp = null;
        }
    }

    // ================== Setter Methods to Validate ==================

    private Boolean setname() {
        return this.name != null;
    }

    private Boolean setage() {
        return String.valueOf(this.age) != null;
    }

    private Boolean setnumberofphone() {
        return String.valueOf(this.numphon) != null;
    }

    private Boolean setcountry() {
        return this.country != null;
    }

    private Boolean setresadd() {
        return this.resiadd != null;
    }

    private Boolean setemail() {
        return this.email != null;
    }

    private Boolean setpassword() {
        return this.password != null;
    }

    public Boolean setexp() {
        return this.exp != null;
    }

    /**
     * This method checks if all the user data is valid.
     * If true, creates a Profile object with the current data.
     *
     * @return true if profile creation is successful, otherwise false
     */
    public Boolean createprof() {
        if (setname() && setage() && setnumberofphone() && setcountry() && setresadd() && setemail() && setpassword() && setexp() != null) {
            Profile prof = new Profile(this.name, String.valueOf(this.age), String.valueOf(this.age), this.country, this.resiadd, this.email, this.password, this.exp);
            if (prof.validateprofile() == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
