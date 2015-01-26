package pojo;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Order {
    private int id, customerId;
    private long startTime;
    private boolean currentlyProcessing;
    private ProcessingTime maxProcessingTime;
    private boolean isComplete;
    private boolean customerWaiting;

    public Order(int id, int customerId, int maxProcessingTime) {
        this.id = id;
        this.customerId = customerId;
        this.maxProcessingTime = new ProcessingTime(maxProcessingTime);
        startTime = System.currentTimeMillis();
        currentlyProcessing = false;
        isComplete = false;
        customerWaiting = false;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean isCurrentlyProcessing() {
        return currentlyProcessing;
    }

    public void setCurrentlyProcessing(boolean currentlyProcessing) {
        this.currentlyProcessing = currentlyProcessing;
    }

    public ProcessingTime getMaxProcessingTime() {
        return maxProcessingTime;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", startTime=" + startTime +
                ", currentlyProcessing=" + currentlyProcessing +
                ", maxProcessingTime=" + maxProcessingTime +
                ", isComplete=" + isComplete +
                ", customerWaiting=" + customerWaiting +
                '}';
    }
}