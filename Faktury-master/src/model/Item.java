package model;

import java.io.Serializable;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Item implements Serializable {
    private static int counter = 0;
    private int id = 0;
    private String name;
    private int count;
    private double netPrice;
    private double netValue;
    private double tax;
    private double taxPrice;
    private double grossValue;


    public Item(String name, int count, double netPrice, int tax) {
        id = counter;
        counter++;
        this.name = name;
        this.count = count;
        this.netPrice = netPrice;
        this.tax = tax;

        setNetValue();
        setTaxPrice();
        setGrossValue();
    }

    public Item(int id, String name, int count, double netPrice, int tax) {
        this.id = id;
        counter = id + 1;
        this.name = name;
        this.count = count;
        this.netPrice = netPrice;
        this.tax = tax;

        setNetValue();
        setTaxPrice();
        setGrossValue();
    }

    public void update() {
        setNetValue();
        setTaxPrice();
        setGrossValue();
    }

    private void setNetValue() {
        netValue = count * netPrice;
    }

    private void setTaxPrice() {
        taxPrice = netPrice * (tax / 100);
        round(taxPrice, 2);
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

    public Item setTax(double tax) {
        this.tax = tax;
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

    public double getNetValue() {
        return netValue;
    }

    public double getTax() {
        return tax;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public double getGrossValue() {
        return grossValue;
    }
}
