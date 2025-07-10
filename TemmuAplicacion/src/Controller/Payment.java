// Author: Jefferson David Rico Ruiz

package Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

/**
 * Handles the logic for processing payments.
 * 
 * This class stores payment details, performs validation of card information,
 * generates random payment IDs and timestamps, and determines if a purchase is valid.
 */
public class Payment {

    public Integer PaymentID;
    public String Datepy;
    public Integer CardNumber;
    public Integer SecurityCode;
    public String MethodPayment;

    // Predefined valid card numbers
    private Integer NumCard1 = 1218396892;
    private Integer NumCard2 = 1849501121;
    private Integer NumCard3 = 1238039233;

    // Predefined valid security codes
    private Integer NumSec1 = 321;
    private Integer NumSec2 = 534;
    private Integer NumSec3 = 132;

    /**
     * Constructor that attempts to parse the provided card number and security code strings
     * into integers. If parsing fails, the values are set to null.
     * 
     * @param CardNumber     String input representing the card number
     * @param SecurityCode   String input representing the card security code
     */
    public Payment(String CardNumber, String SecurityCode) {
        try {
            this.CardNumber = Integer.parseInt(CardNumber);
        } catch (Exception e) {
            this.CardNumber = null;
        }

        try {
            this.SecurityCode = Integer.parseInt(SecurityCode);
        } catch (Exception e) {
            this.SecurityCode = null;
        }
    }

    /**
     * Generates a random 4-digit payment ID.
     */
    public void GeneratePaymentID() {
        Random Id = new Random();
        Integer randId = Id.nextInt(9000) + 1000; // Generates between 1000–9999
        this.PaymentID = randId;
    }

    /**
     * Sets the current date as the payment date in dd/MM/yyyy HH:mm:ss format.
     */
    public void GenerateDate() {
        LocalDate date = LocalDate.now();
        // Note: SimpleDateFormat works with java.util.Date, not java.time.LocalDate
        SimpleDateFormat Formatdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strdate = Formatdate.format(java.sql.Date.valueOf(date));
        this.Datepy = strdate;
    }

    /**
     * Validates if the provided card number matches one of the predefined valid numbers.
     * Also checks for format issues like short length or dash characters.
     * 
     * @param CardNumber   String input representing the card number
     * @return             The parsed card number if valid, or null otherwise
     */
    public Integer ValidateCardNumber(String CardNumber) {
        if (CardNumber.length() < 10 || CardNumber.contains("-")) {
            this.CardNumber = Integer.parseInt(CardNumber);
            this.CardNumber = null;
        } else {
            if (this.NumCard1 == this.CardNumber) {
                return Integer.parseInt(CardNumber);
            } else if (this.NumCard2 == this.CardNumber) {
                return Integer.parseInt(CardNumber);
            } else if (this.NumCard3 == this.CardNumber) {
                return Integer.parseInt(CardNumber);
            } else {
                return this.CardNumber = null;
            }
        }
        return this.CardNumber = null;
    }

    /**
     * Validates if the provided security code matches one of the predefined valid codes.
     * Also checks for invalid format.
     * 
     * @param SecurityCode   String input representing the card's security code
     * @return               The parsed code if valid, or null otherwise
     */
    public Integer ValidateSecurityCard(String SecurityCode) {
        if (SecurityCode.length() > 3 || SecurityCode.contains("-")) {
            this.SecurityCode = Integer.parseInt(SecurityCode);
            this.SecurityCode = null;
        } else {
            if (this.NumSec1 == this.SecurityCode) {
                return Integer.parseInt(SecurityCode);
            } else if (this.NumSec2 == this.SecurityCode) {
                return Integer.parseInt(SecurityCode);
            } else if (this.NumSec3 == this.SecurityCode) {
                return Integer.parseInt(SecurityCode);
            } else {
                return this.SecurityCode = null;
            }
        }
        return this.SecurityCode = null;
    }

    /**
     * Checks if a card number was successfully parsed and validated.
     * 
     * @return true if CardNumber is not null
     */
    public Boolean getNumberCard() {
        return this.CardNumber != null;
    }

    /**
     * Checks if a security code was successfully parsed and validated.
     * 
     * @return true if SecurityCode is not null
     */
    public Boolean getSecurityCard() {
        return this.SecurityCode != null;
    }

    /**
     * Determines whether a purchase is valid based on card number and security code checks.
     * 
     * @return true if both card number and security code are valid
     */
    public Boolean ValidatePurchase() {
        if (getNumberCard() && getSecurityCard() != null) {
            return true;
        } else {
            return false;
        }
    }
}

