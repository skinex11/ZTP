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


    public void display(ArrayList<Invoice> invoices) {
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


        System.out.println("What would you like to do:");
        System.out.println("1. Show invoices");
        System.out.println("2. Create invoice");
        System.out.println("3. Create item");
        System.out.println("4. Update invoice");
        System.out.println("5. Update item");
        System.out.println("6. Delete invoice");
        System.out.println("7. Delete item");
        System.out.println("8. Delete all invoices");
        System.out.println("9. Delete all items");
        System.out.println("10. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showInvoices();
                    break;
                case 2:
                    createInvoice(scanner);
                    break;
                case 3:
                    createItem(scanner);
                    break;
                case 4:
                    updateInvoice(scanner);
                    break;
                case 5:
                    updateItem(scanner);
                    break;
                case 6:
                    deleteInvoice(scanner);
                    break;
                case 7:
                    deleteItem(scanner);
                    break;
                case 8:
                    deleteAllInvoices();
                    break;
                case 9:
                    deleteAllItems(scanner);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose proper option!");
                    break;
            }
        }
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
