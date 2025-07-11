
// Author: Jefferson David Rico Ruiz

package Controller;

/**
 * This class receives the data entered by the user and validates some
 * conditions to either keep the data or discard it by setting it to null.
 */
public class Register {

    // === Attributes to hold user data ===
    public String name;
    public Integer age;
    public Long numphon;
    public String country;
    public String resiadd;
    public String email;
    public String password;
    public String exp;

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
        setname(name);
        setage(age);
        setnumberofphone(numphon);
        setcountry(country);
        setresaddr(resiadd);
        setemail(email);
        setpassword(password);
        setexp(exp);
    }

    // === Private Setters with Validation ===

    /**
     * Validates the name. It must have at least 3 characters.
     */
    private void setname(String name) {
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
     * Validates the age. It must be 18 or older.
     */
    private void setage(String age) {
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
     * Validates the phone number. It must have exactly 10 digits.
     */
    private void setnumberofphone(String numphon) {
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
     * Assigns the country directly.
     */
    private void setcountry(String country) {
        try {
            this.country = country;
        } catch (Exception e) {
            this.country = null;
        }
    }

    /**
     * Assigns the residence address directly.
     */
    private void setresaddr(String resiadd) {
        try {
            this.resiadd = resiadd;
        } catch (Exception e) {
            this.resiadd = null;
        }
    }

    /**
     * Validates the email. Must contain '@gmail.com' or '@hotmail.com'.
     */
    private void setemail(String email) {
        try {
            this.email = email;
            if (!(this.email.contains("@gmail.com") || this.email.contains("@hotmail.com"))) {
                this.email = null;
            }
        } catch (Exception e) {
            this.email = null;
        }
    }

    /**
     * Validates the password. Must be at least 6 characters long.
     */
    private void setpassword(String password) {
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
     * Assigns the work experience directly.
     */
    private void setexp(String exp) {
        try {
            this.exp = exp;
        } catch (Exception e) {
            this.exp = null;
        }
    }

    // === Internal Getters to Validate Field Presence ===

    private Boolean getname() {
        return this.name != null;
    }

    private Boolean getage() {
        return this.age != null;
    }

    private Boolean getnumberofphone() {
        return this.numphon != null;
    }

    private Boolean getcountry() {
        return this.country != null;
    }

    private Boolean getresadd() {
        return this.resiadd != null;
    }

    private Boolean getemail() {
        return this.email != null;
    }

    private Boolean getpassword() {
        return this.password != null;
    }

    public Boolean getexp() {
        return this.exp != null;
    }

    /**
     * This method validates all the user inputs and attempts to create a Profile object.
     * If the profile passes its internal validation, the user is successfully registered.
     *
     * @return true if profile creation is successful, false otherwise
     */
    public Boolean createprof() {
        if (getname() && getage() && getnumberofphone() && getcountry() &&
            getresadd() && getemail() && getpassword() ) {

            Profile prof = new Profile(
                this.name,
                String.valueOf(this.age),
                String.valueOf(this.numphon),
                this.country,
                this.resiadd,
                this.email,
                this.password,
                this.exp
            );

            return prof.validateprofile();

        } else {
            return false;
        }
    }
}




