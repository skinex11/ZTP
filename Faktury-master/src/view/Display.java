package view;

import controller.Controller;
import model.Invoice;
import model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    private String formatInvoice = "|%-4d| %-18s | %-62s |%n";

    private String format = "|%-4d| %-18s | %-5d | %-9.2f | %-9.2f | %-3.0f | %-9.2f | %-12.2f |%n";

    private Controller controller = new Controller();

    public void display(ArrayList<Invoice> invoices) {
        for (int i = 0; i < invoices.size(); i++) {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("|ID  | Name               | Date                                                           |");
            System.out.println("|----|--------------------|----------------------------------------------------------------|");
            Invoice temp1 = invoices.get(i);
            ArrayList<Item> items = temp1.getItems();
            System.out.format(formatInvoice, temp1.getId(), temp1.getName(), temp1.getDate());

            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("|ID  | Name               | Count | net Price | net Value | Vat | vat Price | gross Value  |");
            System.out.println("|----|--------------------|-------|-----------|-----------|-----|-----------|--------------|");

            for (int j = 0; j < items.size(); j++) {
                Item temp = items.get(j);
                System.out.format(format, temp.getId(), temp.getName(), temp.getCount(), temp.getNetPrice(),
                        temp.getNetValue(), temp.getTax(), temp.getTaxPrice(), temp.getGrossValue());
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------");


        System.out.println("What would you like to do:");
        System.out.println("1. Create invoice");
        System.out.println("2. Create item");
        System.out.println("3. Update invoice");
        System.out.println("4. Update item");
        System.out.println("5. Delete invoice");
        System.out.println("6. Delete item");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int choice;

        while (true) {
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    createInvoice(s);
                    break;
                case 2:
                    createItem(s);
                    break;
                case 3:
                    updateInvoice(s);
                    break;
                case 4:
                    updateItem(s);
                    break;
                case 5:
                    deleteInvoice(s);
                    break;
                case 6:
                    deleteItem(s);
                    break;
                case 7:
                    System.exit(0);
            }
        }

    }

    private void deleteItem(Scanner s) {
        int id;
        int itemId;
        System.out.println("Invoice id:");
        id = s.nextInt();
        System.out.println("Item id:");
        itemId = s.nextInt();
        controller.deleteItem(id, itemId);
    }

    private void deleteInvoice(Scanner s) {
        int id;
        System.out.println("Invoice id:");
        id = s.nextInt();
        controller.deleteInvoice(id);
    }

    private void updateItem(Scanner s) {
        int invoiceID;
        int itemID;
        String name;
        int count;
        double netPrice;
        int tax;
        System.out.println("Invoice ID:");
        invoiceID = s.nextInt();
        System.out.println("Item ID:");
        itemID = s.nextInt();
        s.nextLine();
        System.out.println("Product name:");
        name = s.nextLine();
        System.out.println("Product count:");
        count = s.nextInt();
        System.out.println("Product net price:");
        netPrice = s.nextDouble();
        System.out.println("Tax");
        tax = s.nextInt();
        controller.updateItem(invoiceID, itemID, name, count, netPrice, tax);
    }

    private void updateInvoice(Scanner s) {
        int invoiceId;
        System.out.println("Invoice id:");
        invoiceId = s.nextInt();
        String name;
        s.nextLine();
        System.out.println("Invoice name:");
        name = s.nextLine();
        controller.updateInvoice(invoiceId, name);
    }

    private void createItem(Scanner s) {
        int invoiceID;
        String name;
        int count;
        double netPrice;
        int tax;
        System.out.println("Invoice ID:");
        invoiceID = s.nextInt();
        s.nextLine();
        System.out.println("Product name:");
        name = s.nextLine();
        System.out.println("Product count:");
        count = s.nextInt();
        System.out.println("Product net price:");
        netPrice = s.nextDouble();
        System.out.println("Tax");
        tax = s.nextInt();
        controller.createItem(invoiceID, name, count, netPrice, tax);
    }

    private void createInvoice(Scanner s) {
        s.nextLine();
        System.out.println("Invoice name:");
        String name = s.nextLine();
        controller.createInvoice(name);
    }
}
