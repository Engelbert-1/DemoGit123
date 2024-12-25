/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Book;

/**
 *
 * @author win
 */
public class Node {
    public Book info;
    public Node next;

    public Node() {
    }

    public Node(Book info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Book info) {
        this(info,null);
    }
    
}
