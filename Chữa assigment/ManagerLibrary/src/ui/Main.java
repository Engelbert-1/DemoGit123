/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bo.MyList;
import entity.Book;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyList list = new MyList();
        while (true) {
            int choice = Validator.getInt("1.1.      Load data from file\n"
                    + "1.2.      Input & add to the end\n"
                    + "1.3.      Display data\n"
                    + "1.4.      Save book list to file\n"
                    + "1.5.      Search by bcode\n"
                    + "1.6.      Delete by bcode\n"
                    + "1.7.      Sort by bcode\n"
                    + "1.8.      Input & add to beginning\n"
                    + "1.9.      Add after position  k\n"
                    + "1.10.    Delete position k\n"
                    + "Enter your choice : ", "Just be 1->10", "Invalid!", 1, 10);
            switch (choice) {
                case 1:
                    try {
                        list.loadFile("book.txt");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    Book x = new Book();
                    x.input();
                    list.addLast(x);
                    break;
                case 3:
                    list.displayAllBook();
                    break;
                case 4:
                    try {
                        list.saveFile("book.txt");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    String bcode = Validator.getString("Enter bcode: ", "Bcode can not empty!!", "^(?!\\s*$).+");
                    if (list.searchByID(bcode) == null) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Found: ");
                        System.out.println(list.searchByID(bcode).info);
                    }
                    break;
                case 6:
                    bcode = Validator.getString("Enter bcode: ", "Bcode can not empty!!", "^(?!\\s*$).+");
                    list.dele(bcode);
                    break;
                case 7:
                    list.sortByFor();
                    break;
                case 8:
                    x = new Book();
                    x.input();
                    list.addFirst(x);
                    break;
                case 9:
                    int k = Validator.getInt("Enter position k: ", "Just be >=-1",
                            "Invalid!", -1, Integer.MAX_VALUE);
                    x = new Book();
                    x.input();
                    list.insertAfterIndexK(x, k);
                    break;
                case 10:
                    k = Validator.getInt("Enter position k: ", "Just be >=-1",
                            "Invalid!", 0, Integer.MAX_VALUE);
                    list.dele(k);
                    break;
            }
        }
    }

}
