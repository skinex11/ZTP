package Model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String name;
    private int count;
    private double netPrice;
    private double taxPrice;
    private double grossValue;

    public Item(int id, String name, int count, double netPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.netPrice = netPrice;

        setTaxPrice();
        setGrossValue();
    }

    public void update() {
        setTaxPrice();
        setGrossValue();
    }

    private void setTaxPrice() {
        taxPrice = netPrice * 0.23;
        Math.round(taxPrice);
    }

    private void setGrossValue() {
        grossValue = netPrice + taxPrice;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setCount(int count) {
        this.count = count;
        return this;
    }

    public Item setNetPrice(double netPrice) {
        this.netPrice = netPrice;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public double getGrossValue() {
        return grossValue;
    }
}

