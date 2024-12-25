/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
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
        while (true) {
            int arr[] = {3, 1, 4, 2, 1, 1, -8, 10};
            MyList list = new MyList();
            list.clear();
            list.addMany(arr);
            int choice = Validator.getInt("========Menu============\n"
                    + "1. add a node with value x at the head of a list.\n"
                    + "2. add a node with value x at the tail of a list.\n"
                    + "3. add a node with value x after the node p.\n"
                    + "4. traverse from head to tail and dislay info of all nodes in the list.\n"
                    + "5. delete the head and return its info.\n"
                    + "6. delete the tail and return its info.\n"
                    + "7. delete the node after the node p and return its info.\n"
                    + "8.......\nEnter your choice: ", "Just 1->25", "Invalid!", 1, 25);
            switch (choice) {
                case 1:
                    System.out.println("Before: ");
                    list.traverse();
                    int x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    list.addFirst(x);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 2:
                    System.out.println("Before: ");
                    list.traverse();
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    list.addLast(x);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 3:
                    System.out.println("Before: ");
                    list.traverse();
                    int k = Validator.getInt("Enter index of Node p: ", "Just be >=0",
                            "Invalid!", 0, Integer.MAX_VALUE);
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    Node p = list.getNodeAtIndex(k);
                    list.addAfter(p, x);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 4:
                    list.traverse();
                    break;
                case 5:
                    System.out.println("Before: ");
                    list.traverse();
                    try {
                        list.deleteFromHead();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 6:
                    System.out.println("Before: ");
                    list.traverse();
                    try {
                        list.deleteFromTail();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 7:
                    System.out.println("Before: ");
                    list.traverse();
                    k = Validator.getInt("Enter index of Node p: ", "Just be >=0",
                            "Invalid!", 0, Integer.MAX_VALUE);
                    p = list.getNodeAtIndex(k);
                    try {
                        list.deleteAfter(p);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 8:
                    System.out.println("Before: ");
                    list.traverse();
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    list.dele(x);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 9:
                    System.out.println("Before: ");
                    list.traverse();
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    p = list.findFirstNode(x);
                    System.out.println(p.info);
                    break;
                case 10:
                    list.traverse();
                    System.out.println("Size is: " + list.size());
                    break;
                case 11:
                    System.out.println("Before: ");
                    list.traverse();
                    int position = Validator.getInt("Enter position of Node p: ", "Just be >= 1",
                            "Invalid!", 1, Integer.MAX_VALUE);
                    list.deleAtIndex(position - 1);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 12:
                    System.out.println("Before: ");
                    list.traverse();
                    list.sort();
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 13:
                    System.out.println("Before: ");
                    list.traverse();
                    k = Validator.getInt("Enter index of Node p: ", "Just be >=0",
                            "Invalid!", 0, Integer.MAX_VALUE);
                    p = list.getNodeAtIndex(k);
                    list.dele(p);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 14:
                    System.out.println(Arrays.toString(list.toArray()));
                    break;
                case 15:
                    System.out.println("Sorted list1: ");
                    list.sort();
                    list.traverse();
                    int arr2[] = {-5, -2, -7};
                    MyList list2 = new MyList();
                    list2.addMany(arr2);
                    System.out.println("Sorted list2: ");
                    list2.sort();
                    list2.traverse();
                    list.mergeAndSort(list2);
                    System.out.println("After merge two list: ");
                    list.traverse();
                    break;
                case 16:
                    System.out.println("Before: ");
                    list.traverse();
                    k = Validator.getInt("Enter index of Node p: ", "Just be >=0",
                            "Invalid!", 0, Integer.MAX_VALUE);
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    p = list.getNodeAtIndex(k);
                    list.addBefore(p, x);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 17:
                    System.out.println("List 1: ");
                    list.traverse();
                    int arr3[] = {-5, -2, -7};
                    MyList list3 = new MyList();
                    list3.addMany(arr3);
                    System.out.println("List 2: ");
                    list3.traverse();
                    list.Attach(list3);
                    System.out.println("After: ");
                    list.traverse();
                    break;
                case 18:
                    System.out.println("List: ");
                    list.traverse();
                    try {
                        System.out.println("Max: " + list.max());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 19:
                    System.out.println("List: ");
                    list.traverse();
                    try {
                        System.out.println("Min: " + list.min());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 20:
                    System.out.println("List: ");
                    list.traverse();
                    try {
                        System.out.println("Sum: " + list.sum());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 21:
                    System.out.println("List: ");
                    list.traverse();
                    try {
                        System.out.println("AVG: " + list.avg());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 22:
                    System.out.println("List: ");
                    list.traverse();
                    System.out.println("List is accending? : " + list.sorted());
                case 23:
                    list.sort();
                    System.out.println("Before: ");
                    list.traverse();
                    x = Validator.getInt("Enter x: ", "Error range!",
                            "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    list.insert(x);
                    System.out.println("After: ");
                    list.traverse();
                case 24:
                    System.out.println("Before: ");
                    list.traverse();
                    list.reverse();
                    System.out.println("After: ");
                    list.traverse();
                case 25:
                    int arr4[] = {3, 1, 4, 2, 1, 1, -8, 10,7};
                    System.out.println("List 1: ");
                    list.traverse();
                    MyList list4 = new MyList();
                    list4.addMany(arr4);
                    System.out.println("List 2: ");
                    list4.traverse();
                    System.out.println("List 1 equal List 2 ? : "+list.equal(list4));

            }
        }
    }

}
