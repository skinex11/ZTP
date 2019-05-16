package Controler;

import Model.Invoice;
import Model.Item;
import View.Display;

import java.io.*;
import java.util.ArrayList;

public class Controler {
    private static Display display = new Display();
    private static ArrayList<Invoice> invoices = readFromFile();

    public static void main(String args[]) {
        display.display(readFromFile());
    }

    public void showInvoices() {
        if(invoices.size() == 0) System.out.println("No invoices!");
        display.display(invoices);
    }

    public void createInvoice(String name) {
        int id = invoices.size();
        Invoice newInvoice = new Invoice(id, name, new ArrayList<>());
        invoices.add(newInvoice);
        saveToFile(invoices);
    }


    public void createItem(int id, String name, int count, double netPrice) {
        int itemid = invoices.get(id).getItems().size();
        invoices.get(id).getItems().add(new Item(itemid, name, count, netPrice));
        saveToFile(invoices);
    }

    public void updateInvoice(int id, String name) {
        Invoice invoice = getInvoiceByID(id);
        int position = invoices.indexOf(invoice);
        invoices.get(position).setName(name);
        saveToFile(invoices);
    }

    public void updateItem(int invoiceID, int itemID, String name, int count, double netPrice) {
        Invoice invoice = getInvoiceByID(invoiceID);
        int invoicePosition = invoices.indexOf(invoice);
        ArrayList<Item> items = invoice.getItems();
        Item item = getItemByID(itemID, invoiceID);
        int itemPosition = items.indexOf(item);
        invoices.get(invoicePosition).getItems().get(itemPosition).setName(name).setCount(count).setNetPrice(netPrice).update();
        saveToFile(invoices);
    }

    public void deleteInvoice(int id) {
        Invoice invoice = getInvoiceByID(id);
        int position = invoices.indexOf(invoice);
        if(position != -1) {invoices.remove(position);}
        saveToFile(invoices);
    }

    public void deleteItem(int invoiceID, int itemID) {
        Invoice invoice = getInvoiceByID(invoiceID);
        int invoicePosition = invoices.indexOf(invoice);
        ArrayList<Item> items = invoice.getItems();
        Item item = getItemByID(itemID, invoiceID);
        int itemPosition = items.indexOf(item);
        invoices.get(invoicePosition).getItems().remove(itemPosition);
        saveToFile(invoices);
    }

    public void deleteAllInvoices() {
        invoices.clear();
        saveToFile(invoices);
    }

    public void deleteAllItems(int invoiceID) {
        Invoice invoice = getInvoiceByID(invoiceID);
        int invoicePosition = invoices.indexOf(invoice);
        invoices.get(invoicePosition).getItems().clear();
        saveToFile(invoices);
    }

    private static void saveToFile(ArrayList<Invoice> invoices) {
        try {
            ObjectOutputStream ss = new ObjectOutputStream(new FileOutputStream("data.txt"));
            ss.writeObject(invoices);
        } catch (IOException e) {
            e.printStackTrace();
        }
        display.display(invoices);
    }

    private static ArrayList<Invoice> readFromFile() {

        try {
            ObjectInputStream ss = new ObjectInputStream(new FileInputStream("data.txt"));
            return (ArrayList<Invoice>) ss.readObject();
        } catch (IOException e) {
            System.out.println("File not found!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private Invoice getInvoiceByID(int id){
        Invoice invoice = new Invoice("",new ArrayList<Item>());
        for (Invoice i: invoices) {
            if(i.getId() == id) { invoice = i;}
        }
        return invoice;
    }

    private Item getItemByID(int itemID, int invoiceID){
        Item item = new Item(-1,"",-1,-1);
        Invoice invoice = getInvoiceByID(invoiceID);
        ArrayList<Item> items = invoice.getItems();
        for (Item i: items) {
            if(i.getId() == itemID) { item = i;}
        }
        return item;
    }
}

