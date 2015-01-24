package Object;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Bestelling {
    private int id, klantid;
    private Date start_tijd;
    boolean verwerking;
    double Duur;

    public Bestelling(int id, int klantid, Date start_tijd, boolean verwerking, double duur) {
        this.id = id;
        this.klantid = klantid;
        this.start_tijd = start_tijd;
        this.verwerking = verwerking;
        Duur = duur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public Date getStart_tijd() {
        return start_tijd;
    }

    public void setStart_tijd(Date start_tijd) {
        this.start_tijd = start_tijd;
    }

    public boolean isVerwerking() {
        return verwerking;
    }

    public void setVerwerking(boolean verwerking) {
        this.verwerking = verwerking;
    }

    public double getDuur() {
        return Duur;
    }

    public void setDuur(double duur) {
        Duur = duur;
    }

    @Override
    public String toString() {
        return "Bestelling{" +
                "id=" + id +
                ", klantid=" + klantid +
                ", start_tijd=" + start_tijd +
                ", verwerking=" + verwerking +
                ", Duur=" + Duur +
                '}';
    }
}

