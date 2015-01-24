package pojo;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Wouter on 1/24/2015.
 */
public class Order {
    private int id, customerId;
    private Date startTime;
    private boolean currentlyProcessing;
    private int maxProcessingTime;
    private boolean isComplete;
    private boolean customerWaiting;

    public Order(int id, int customerId, int maxProcessingTime) {
        this.id = id;
        this.customerId = customerId;
        this.maxProcessingTime = maxProcessingTime;
        startTime = Calendar.getInstance().getTime();
        currentlyProcessing = false;
        isComplete = false;
        customerWaiting = false;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public boolean isCurrentlyProcessing() {
        return currentlyProcessing;
    }

    public void setCurrentlyProcessing(boolean currentlyProcessing) {
        this.currentlyProcessing = currentlyProcessing;
    }

    public int getMaxProcessingTime() {
        return maxProcessingTime;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean isCustomerWaiting() {
        return customerWaiting;
    }

    public void setCustomerWaiting(boolean customerWaiting) {
        this.customerWaiting = customerWaiting;
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