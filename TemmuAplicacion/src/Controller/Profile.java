package Controller;

import Model.data;

/**
 * The Profile class extends Register and serves to validate the user's profile information.
 * It checks if each attribute has valid data and determines if the profile is acceptable.
 */
public class Profile extends Register {

    /**
     * Constructor for the Profile class.
     * Initializes the attributes by parsing and assigning the data received from the form.
     *
     * @param name     Will store the username
     * @param age      Will store the age of the user (as String to be parsed)
     * @param numphon  Will store the phone number of the user (as String to be parsed)
     * @param country  Will store the country of the user
     * @param resiadd  Will store the residence address of the user
     * @param email    Will store the email of the user
     * @param password Will store the password of the user
     * @param exp      Will store the work experience of the user
     */
    public Profile(String name, String age, String numphon, String country, String resiadd, String email, String password, String exp) {
        super(name, age, numphon, country, resiadd, email, password, exp);
        this.name = name;
        this.age = Integer.parseInt(age);
        this.numphon = Long.parseLong(numphon);
        this.country = country;
        this.resiadd = resiadd;
        this.email = email;
        this.password = password;
        this.exp = exp;
    }

    /**
     * Validates if the name is assigned correctly.
     * 
     * @return true if the name is valid, false otherwise
     */
    public Boolean assignname() {
        if (name == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the age is assigned correctly.
     * 
     * @return true if the age is valid, false otherwise
     */
    public Boolean assignage() {
        if (age == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the phone number is assigned correctly.
     * 
     * @return true if the phone number is valid, false otherwise
     */
    public Boolean assignnumphon() {
        if (numphon == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the country is assigned correctly.
     * 
     * @return true if the country is valid, false otherwise
     */
    public Boolean assigncountry() {
        if (country == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the residence address is assigned correctly.
     * 
     * @return true if the residence address is valid, false otherwise
     */
    public Boolean assignresaddr() {
        if (resiadd == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the email is assigned correctly.
     * 
     * @return true if the email is valid, false otherwise
     */
    public Boolean assignemail() {
        if (email == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the password is assigned correctly.
     * 
     * @return true if the password is valid, false otherwise
     */
    public Boolean assignpassword() {
        if (password == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the work experience is assigned correctly.
     * 
     * @return true if the experience is valid, false otherwise
     */
    public Boolean assignexp() {
        if (exp == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates the entire profile by checking if all required fields are valid.
     * 
     * @return true if the profile passes validation, false otherwise
     */
    public Boolean validateprofile() {
        if (assignname() && assignage() && assignnumphon() && assigncountry() && assignresaddr() && assignemail()
                && assignpassword() == true) {
            return true;
        } else if (assignname() && assignage() && assignnumphon() && assigncountry() && assignresaddr() && assignemail()
                && assignpassword() && assignexp() == true) {
            return true;
        } else {
            return false;
        }
    }

}



