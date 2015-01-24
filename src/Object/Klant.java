package Object;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Klant {
    private int id,leeftijd;
    private String Voornaam, tussenvoegsel, achternaam,geslacht, plaats, email;

    public Klant(int id, int leeftijd, String voornaam, String tussenvoegsel, String achternaam, String geslacht, String plaats, String email) {
        this.id = id;
        this.leeftijd = leeftijd;
        Voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.plaats = plaats;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public void setVoornaam(String voornaam) {
        Voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "id=" + id +
                ", leeftijd=" + leeftijd +
                ", Voornaam='" + Voornaam + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geslacht='" + geslacht + '\'' +
                ", plaats='" + plaats + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
