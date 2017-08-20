package com.notification.model;

/**
 * Created by dheeraj on 17/08/17.
 */
public class TagAndSpent {
    String tag;
    String amount;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TagAndSpent{" +
                "tag='" + tag + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
