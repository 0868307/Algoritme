package pojo;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Customer {
    private int id,leeftijd;
    private String voornaam, tussenvoegsel, achternaam,geslacht, plaats, email;

    public Customer(int id, int leeftijd, String voornaam, String tussenvoegsel, String achternaam, String geslacht, String plaats, String email) {
        this.id = id;
        this.leeftijd = leeftijd;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", leeftijd=" + leeftijd +
                ", voornaam='" + voornaam + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geslacht='" + geslacht + '\'' +
                ", plaats='" + plaats + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (leeftijd != customer.leeftijd) return false;
        if (voornaam != null ? !voornaam.equals(customer.voornaam) : customer.voornaam != null) return false;
        if (achternaam != null ? !achternaam.equals(customer.achternaam) : customer.achternaam != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (geslacht != null ? !geslacht.equals(customer.geslacht) : customer.geslacht != null) return false;
        if (plaats != null ? !plaats.equals(customer.plaats) : customer.plaats != null) return false;
        if (tussenvoegsel != null ? !tussenvoegsel.equals(customer.tussenvoegsel) : customer.tussenvoegsel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + leeftijd;
        result = 31 * result + (voornaam != null ? voornaam.hashCode() : 0);
        result = 31 * result + (tussenvoegsel != null ? tussenvoegsel.hashCode() : 0);
        result = 31 * result + (achternaam != null ? achternaam.hashCode() : 0);
        result = 31 * result + (geslacht != null ? geslacht.hashCode() : 0);
        result = 31 * result + (plaats != null ? plaats.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
