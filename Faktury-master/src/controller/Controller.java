package controller;

import model.Invoice;
import model.Item;
import view.Display;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    private static Display display = new Display();

    public static void main(String args[]) {
        display.display(readData());
    }


    public void createInvoice(String name) { // tested
        ArrayList<Invoice> invoices = readData();
        int id = invoices.size();
        invoices.add(new Invoice(id, name, new ArrayList<>()));
        saveData(invoices);
        display.display(invoices);
    }


    public void createItem(int id, String name, int count, double netPrice, int tax) { // tested
        ArrayList<Invoice> invoices = readData();
        int itemid = invoices.get(id).getItems().size();

        invoices.get(id).getItems().add(new Item(itemid, name, count, netPrice, tax));
        saveData(invoices);
        display.display(invoices);
    }

    public void updateInvoice(int id, String name) { // tested
        ArrayList<Invoice> invoices = readData();
        invoices.get(id).setName(name);
        saveData(invoices);
        display.display(invoices);
    }

    public void updateItem(int invoiceId, int itemId, String name, int count, double netPrice, double tax) { // tested
        ArrayList<Invoice> invoices = readData();
        invoices.get(invoiceId).getItems().get(itemId).setName(name).setCount(count).setNetPrice(netPrice).setTax(tax).update();
        saveData(invoices);
        display.display(invoices);
    }

    public void deleteInvoice(int id) { // tested
        ArrayList<Invoice> invoices = readData();
        invoices.remove(id);
        saveData(invoices);
        display.display(invoices);
    }

    public void deleteItem(int invoiceId, int itemId) { // tested
        ArrayList<Invoice> invoices = readData();
        invoices.get(invoiceId).getItems().remove(itemId);
        saveData(invoices);
        display.display(invoices);
    }

    private static void saveData(ArrayList<Invoice> invoices) {
        try {
            ObjectOutputStream ss = new ObjectOutputStream(new FileOutputStream("data.bin"));
            ss.writeObject(invoices);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Invoice> readData() {

        try {
            ObjectInputStream ss = new ObjectInputStream(new FileInputStream("data.bin"));
            return (ArrayList<Invoice>) ss.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
