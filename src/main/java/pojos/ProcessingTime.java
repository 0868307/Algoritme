package pojos;

/**
 * Created by darryl on 24-1-15.
 */
public class ProcessingTime {
    private int time;

    public ProcessingTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ProcessingTime{" +
                "time=" + time +
                '}';
    }
}
