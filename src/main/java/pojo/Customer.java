package pojo;

import java.util.HashMap;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Customer extends Pojo {
    private final String ATTRIBUTE_ID = "id";
    private final String ATTRIBUTE_LEEFTIJD = "leeftijd";
    private final String ATTRIBUTE_VOORNAAM = "voornaam";
    private final String ATTRIBUTE_TUSSENNAAM = "tussenvoegsel";
    private final String ATTRIBUTE_ACHTERNAAM = "achternaam";
    private final String ATTRIBUTE_GESLACHT = "geslacht";
    private final String ATTRIBUTE_PLAATS = "plaats";
    private final String ATTRIBUTE_EMAIL = "email";

    public Customer(int id, int leeftijd, String voornaam, String tussenvoegsel, String achternaam, String geslacht, String plaats, String email) {
        attributes.put(ATTRIBUTE_ID,id);
        attributes.put(ATTRIBUTE_LEEFTIJD,leeftijd);
        attributes.put(ATTRIBUTE_VOORNAAM,voornaam);
        attributes.put(ATTRIBUTE_TUSSENNAAM,tussenvoegsel);
        attributes.put(ATTRIBUTE_ACHTERNAAM,achternaam);
        attributes.put(ATTRIBUTE_GESLACHT,geslacht);
        attributes.put(ATTRIBUTE_PLAATS,plaats);
        attributes.put(ATTRIBUTE_EMAIL,email);
    }

    public int getId() {
        return getInteger(ATTRIBUTE_ID);
    }

    public int getLeeftijd() {
        return getInteger(ATTRIBUTE_LEEFTIJD);
    }

    public String getAchternaam() {
        return getString(ATTRIBUTE_ACHTERNAAM);
    }
    public String getVoornaam() {
        return getString(ATTRIBUTE_VOORNAAM);
    }
    public String getTussenNaam() {
        return getString(ATTRIBUTE_TUSSENNAAM);
    }
    public String getGeslacht() {
        return getString(ATTRIBUTE_GESLACHT);
    }
    public String getPlaats() {
        return getString(ATTRIBUTE_PLAATS);
    }
    public String getEmail() {
        return getString(ATTRIBUTE_EMAIL);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", leeftijd=" + getLeeftijd() +
                ", voornaam='" + getVoornaam() + '\'' +
                ", tussenvoegsel='" + getTussenNaam() + '\'' +
                ", achternaam='" + getAchternaam() + '\'' +
                ", geslacht='" + getGeslacht() + '\'' +
                ", plaats='" + getPlaats() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (getId() != customer.getId()) return false;
        if (getLeeftijd() != customer.getLeeftijd()) return false;
        if (getVoornaam() != null ? !getVoornaam().equals(customer.getVoornaam()) : customer.getVoornaam() != null) return false;
        if (getAchternaam() != null ? !getAchternaam().equals(customer.getAchternaam()) : customer.getAchternaam() != null) return false;
        if (getEmail() != null ? !getEmail().equals(customer.getEmail()) : customer.getEmail() != null) return false;
        if (getGeslacht() != null ? !getGeslacht().equals(customer.getGeslacht()) : customer.getGeslacht() != null) return false;
        if (getPlaats() != null ? !getPlaats().equals(customer.getPlaats()) : customer.getPlaats() != null) return false;
        if (getTussenNaam() != null ? !getTussenNaam().equals(customer.getTussenNaam()) : customer.getTussenNaam() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getLeeftijd();
        result = 31 * result + (getVoornaam() != null ? getVoornaam().hashCode() : 0);
        result = 31 * result + (getTussenNaam() != null ? getTussenNaam().hashCode() : 0);
        result = 31 * result + (getAchternaam() != null ? getAchternaam().hashCode() : 0);
        result = 31 * result + (getGeslacht() != null ? getGeslacht().hashCode() : 0);
        result = 31 * result + (getPlaats() != null ? getPlaats().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}