package Data.Entities.Users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class User {

    private String firstName;
    private String lastName;
    private String email;
    private String pseudo;
    private long number;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password ;
    @JsonCreator
    public User(@JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("pseudo") String pseudo,
                @JsonProperty("number") Long number,
                @JsonProperty("password") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pseudo = pseudo;
        this.number = number;
        this.password = password ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "\n- firstName='" + firstName + '\'' +
                "\n- lastName='" + lastName + '\'' +
                /*"\n- email='" + email + '\'' +*/
                "\n- pseudo='" + pseudo + '\'' +
                /*"\n- number=" + number +*/
                "\n}";
    }

    public abstract void displayActivityStat();

    public void getNotification() {
        // TODO
    }
}