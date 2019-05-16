package View;

import Controler.Controler;
import Model.Invoice;
import Model.Item;


import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    private String formatInvoice = "|%-4d| %-18s |%n";

    private String formatItem = "|%-4d| %-18s | %-5d | %-9.2f | %-9.2f | %-12.2f |%n";

    private Controler controler = new Controler();


    public void display() {
        System.out.println("What would you like to do:");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayCreate(scanner);
                    break;
                case 2:
                    displayRead(scanner);
                    break;
                case 3:
                    displayUpdate(scanner);
                    break;
                case 4:
                    displayDelete(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
    }

    private void displayRead(Scanner scanner){
        System.out.println("You're in read menu:");
        System.out.println("1.Show invoices");
        System.out.println("2.Return");

        int choice;

        while(true){
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    showInvoices();
                    break;
                case 2:
                    display();
                    break;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
    }

    private void displayCreate(Scanner scanner){
        System.out.println("You're in creation menu:");
        System.out.println("1.Create invoice");
        System.out.println("2.Create item");
        System.out.println("3.Return");

        int choice;

        while(true){
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    createInvoice(scanner);
                    break;
                case 2:
                    createItem(scanner);
                    break;
                case 3:
                    display();
                    break;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
    }

    private void displayUpdate(Scanner scanner){
        System.out.println("You're in update menu:");
        System.out.println("1.Update invoice");
        System.out.println("2.Update item");
        System.out.println("3.Return");

        int choice;

        while(true){
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    updateInvoice(scanner);
                    break;
                case 2:
                    updateItem(scanner);
                    break;
                case 3:
                    display();
                    break;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
    }

    private void displayDelete(Scanner scanner){
        System.out.println("You're in deletion menu:");
        System.out.println("1.Delete invoice");
        System.out.println("2.Delete item");
        System.out.println("3.Delete all invoices");
        System.out.println("4.Delete all items on invoice");
        System.out.println("5.Return");

        int choice;

        while(true){
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    deleteInvoice(scanner);
                    break;
                case 2:
                    deleteItem(scanner);
                    break;
                case 3:
                    deleteAllInvoices();
                    break;
                case 4:
                    deleteAllItems(scanner);
                    break;
                case 5:
                    display();
                    return;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
    }

    public void displayInvoices(ArrayList<Invoice> invoices){
        for (int i = 0; i < invoices.size(); i++) {
            System.out.println("-------------------------");
            System.out.println("|ID  | Name             |");
            System.out.println("|----|------------------|");
            Invoice invoice = invoices.get(i);
            ArrayList<Item> items = invoice.getItems();
            System.out.format(formatInvoice, invoice.getId(), invoice.getName());

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("|ID  | Name               | Count | net Price | vat Price | gross Value  |");
            System.out.println("|----|--------------------|-------|-----------|-----------|--------------|");

            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                System.out.format(formatItem, item.getId(), item.getName(), item.getCount(), item.getNetPrice(),
                        item.getTaxPrice(), item.getGrossValue());
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        display();
    }

    private void showInvoices(){
        controler.showInvoices();
    }

    private void createInvoice(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Invoice name:");
        String name = scanner.nextLine();
        controler.createInvoice(name);
    }

    private void createItem(Scanner scanner) {
        System.out.println("Invoice ID:");
        int invoiceID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Product name:");
        String name = scanner.nextLine();

        System.out.println("Product count:");
        int count = scanner.nextInt();

        System.out.println("Product net price:");
        double netPrice = scanner.nextDouble();
        controler.createItem(invoiceID, name, count, netPrice);
    }

    private void updateInvoice(Scanner scanner) {
        System.out.println("Invoice id:");
        int invoiceId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Invoice name:");
        String name = scanner.nextLine();
        controler.updateInvoice(invoiceId, name);
    }

    private void updateItem(Scanner scanner) {
        System.out.println("Invoice ID:");
        int invoiceID = scanner.nextInt();
        System.out.println("Item ID:");
        int itemID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Product name:");
        String name = scanner.nextLine();
        System.out.println("Product count:");
        int count = scanner.nextInt();
        System.out.println("Product net price:");
        double netPrice = scanner.nextDouble();
        controler.updateItem(invoiceID, itemID, name, count, netPrice);
    }

    private void deleteInvoice(Scanner scanner) {
        System.out.println("Invoice id:");
        int id = scanner.nextInt();
        controler.deleteInvoice(id);
    }

    private void deleteItem(Scanner s) {
        System.out.println("Invoice id:");
        int id = s.nextInt();
        System.out.println("Item id:");
        int itemId = s.nextInt();
        controler.deleteItem(id, itemId);
    }

    private void deleteAllInvoices() {
        controler.deleteAllInvoices();
    }

    private void deleteAllItems(Scanner s) {
        System.out.println("Invoice id:");
        int id = s.nextInt();
        controler.deleteAllItems(id);
    }










}
