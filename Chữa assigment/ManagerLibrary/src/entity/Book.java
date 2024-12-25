/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author win
 */
public class Book {
    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private double price;

    public Book(String bcode, String title, int quantity, int leanded, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = leanded;
        this.price = price;
    }

    public Book() {
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void input(){
        bcode = Validator.getString("Enter bcode: ", "Bcode can not empty!!", "^(?!\\s*$).+");
        title = Validator.getString("Enter title: ", "title can not empty!", "^(?!\\s*$).+");
        quantity = Validator.getInt("Enter quantity: ", "Just be > 0", 
                "Invalid!", 1, Integer.MAX_VALUE);
        lended= Validator.getInt("Enter lended: ", "Just be > 0 and <= quantity", 
                "Invalid!", 1, quantity);
        price = Validator.getDouble("Enter price: ", "Just be >0", "Invalid!", 
                Double.MIN_VALUE, Double.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Book{" + bcode + ", " + title + ", " + quantity + ", " + lended + ", " + price + '}';
    }
    
}
