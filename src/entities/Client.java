package entities;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Client {
    @Override
    public String toString() {
        return name + "(" + birthDate + ")"
                + " - " + email;
    }

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Date birthDate;


    public Client(String name, String email, Date birthDate) {
        this.name = name;
        this.email = email;
        Client.birthDate = birthDate;
    }

    private String name;
    private String email;

    public static Date getBirthDate() {
        return birthDate;
    }

    public static void setBirthDate(Date birthDate) {
        Client.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
