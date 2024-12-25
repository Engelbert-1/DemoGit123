/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author win
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public Node searchByID(String xCode) {
        Node p = head;
        while (p != null) {
            if (p.info.getBcode().equalsIgnoreCase(xCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    public boolean isExisted(String ID) {
        Node p = head;
        while (p != null) {
            if (p.info.getBcode().equalsIgnoreCase(ID)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public void addLast(Book x) {
        if (isExisted(x.getBcode())) {
            System.out.println("This code is existed! Try again!");
            return;
        }
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void addFirst(Book x) {
        if (isExisted(x.getBcode())) {
            System.out.println("This code is existed! Try again!");
            return;
        }
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    public void displayAllBook() {
        if (isEmpty()) {
            System.out.println("This list is empty!!!");
            return;
        }
        System.out.printf("%10s|%15s|%10s|%10s|%10s|%10s\n", "code", "Title", "Quantity", "Lended", "Price", "Value");
        Node p = head;
        while (p != null) {
            System.out.printf("%10s|%15s|%10d|%10d|%10.1f|%10.1f\n", p.info.getBcode(), p.info.getTitle(), p.info.getQuantity(),
                    p.info.getLended(), p.info.getPrice(), p.info.getPrice() * p.info.getQuantity());
            p = p.next;
        }
    }

    public void loadFile(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String bcode;
        String title;
        int quantity;
        int lended;
        double price;
        while (true) {
            s = br.readLine();
            if (s == null) {
                break;
            }
            a = s.split("[|]");
            bcode = a[0].trim();
            title = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());
            lended = 0;
            price = Double.parseDouble(a[3].trim());
            addLast(new Book(bcode, title, quantity, lended, price));
        }
        fr.close();
        br.close();
    }

    public void saveFile(String fname) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        Node p = head;
        while (p != null) {
            pw.printf("%s | %s | %d | %.1f \n", p.info.getBcode(), p.info.getTitle(),
                    p.info.getQuantity(), p.info.getPrice());
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public void removeFirst(Node q) {
        if (q == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void dele(String xCode) {
        Node x = searchByID(xCode);
        if (x == null) {
            System.out.println("Can not found ID! Delete Fail");
            return;
        }
        //Truong hop node muon xoa la node dau tien
        if (x == head) {
            removeFirst(x);
            System.out.println("Delete successfull");
            return;
        }

        //Truong hop node muon xoa la (not nam giua 2 not khac) hoac (nam cuoi) 
        Node p = head;
        while (p.next != x) {
            p = p.next;
        }
        p.next = x.next;
        if (p.next == null) {
            tail = p;
        }
        System.out.println("Delete successfull");
    }

    public void sortByFor() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.getBcode().compareTo(pj.info.getBcode()) > 0) {
                    Book temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

    //count number of node
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    //insert after index k
    public void insertAfterIndexK(Book c, int k) {
        Node newNode = new Node(c);
        if (k >= size()) {
            return;
        }
        if (k == -1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        int count = 0;
        Node p = head;

        while (p != null && count < k) {
            p = p.next;
            count++;
        }

        if (count == k) {
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public void dele(int i) {
        if(i>=size()){
            System.out.println("Invalid!");
            return;
        }
        Node p = getNode(i);
        dele(p.info.getBcode());
    }
}
