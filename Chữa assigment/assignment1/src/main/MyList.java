/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author win
 */
class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println("");
    }

    public void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

    public Node getNodeAtIndex(int index) {
        if (index < 0) {
            // Vị trí index không hợp lệ, có thể trả về null hoặc xử lý khác tùy ý
            return null;
        }

        Node p = head;
        int count = 0;

        while (p != null) {
            if (count == index) {
                // Tìm thấy nút ở vị trí index
                return p;
            }
            p = p.next;
            count++;
        }

        // Nếu vị trí index vượt quá độ dài của danh sách, trả về null
        return null;
    }

    // Delete from head
    public int deleteFromHead() throws Exception {
        if (isEmpty()) {
            throw new Exception("Can not delete!");
        }
        int info = head.info;
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
        }
        return info;
    }

    public int deleteFromTail() throws Exception {
        if (isEmpty()) {
            throw new Exception("Can not delete!");
        }
        int info = tail.info;
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            Node p = head;
            while (p.next != tail) {
                p = p.next;
            }
            tail = p;
            tail.next = null;
        }
        return info;
    }

    // Delete after a given node p
    public int deleteAfter(Node p) throws Exception {
        if (p == null || p.next == null) {
            throw new Exception("Can not delete!");
        }
        Node q = p.next;
        int info = q.info;
        p.next = q.next;
        if (q == tail) { // Update tail if the deleted node was the last one
            tail = p;
        }
        return info;
    }

    public void dele(int x) {
        Node p = findFirstNode(x);// node dau tien co gia tri la x
        if (p == null) {
            System.out.println("Can not found x!");
            return;
        }
        dele(p);
    }

    //search first node have integer/double/string
    public Node findFirstNode(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //funtion 13
    public void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
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

    void deleAtIndex(int i) {
        Node p = getNodeAtIndex(i);
        if (p == null) {
            return;
        }
        dele(p);
    }

    public void sort() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info > pj.info) {
                    int temp = pi.info;
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

    public int[] toArray() {
        int n = size();
        int[] arr = new int[n];
        Node p = head;
        int i = 0;
        while (p != null) {
            arr[i++] = p.info;
            p = p.next;
        }
        return arr;
    }

    public void mergeAndSort(MyList myList2) {
        int[] arr2 = myList2.toArray();
        addMany(arr2);
        sort();
    }

    void addBefore(Node p, int x) {
        if (p == null) {
            return;
        }
        if (p == head) {
            addFirst(x);
        } else {
            Node q = head;
            //Tim node dung truoc node p
            while (q.next != p && q.next != null) {
                q = q.next;
            }
            addAfter(q, x);
        }
    }

    public void Attach(MyList myList2) {
        int[] arr2 = myList2.toArray();
        addMany(arr2);
    }

    public int max() throws Exception {
        if (isEmpty()) {
            throw new Exception("This list is empty!");
        }
        int max = head.info;
        Node p = head;
        while (p != null) {
            if (p.info > max) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

    public int min() throws Exception {
        if (isEmpty()) {
            throw new Exception("This list is empty!");
        }
        int min = head.info;
        Node p = head;
        while (p != null) {
            if (p.info < min) {
                min = p.info;
            }
            p = p.next;
        }
        return min;
    }

    public int sum() throws Exception {
        if (isEmpty()) {
            throw new Exception("This list is empty!");
        }
        int sum = 0;
        Node p = head;
        while (p != null) {
            sum += p.info;
            p = p.next;
        }
        return sum;
    }

    public int avg() throws Exception {
        if (isEmpty()) {
            throw new Exception("This list is empty!");
        }
        return (sum() / size());
    }

    boolean sorted() {
        if (isEmpty() || head == tail) {
            return (true);
        }
        Node f = head, p = f.next;
        while (p != null) {
            if (p.info < f.info) {
                return (false);
            }
            f = p;
            p = p.next;
        }
        return (true);
    }

    public void insert(int x) {
        if (!sorted()) {
            System.out.println("List not sorted accending!");
            return;
        }
        if (x <= head.info) {
            addFirst(x);
        } else if (x >= tail.info) {
            addLast(x);
        } else {
            Node p = head;
            while (p != tail) {
                if (p.info <= x && x <= p.next.info) {
                    addAfter(p, x);
                    return;
                }
                p = p.next;
            }
        }
    }

    public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            int temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
        }
    }

    public boolean equal(MyList list) {
        int n = size();
        int m = list.size();
        if (n != m) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = list.getNode(i);// create a node = getnode index j
            if(pi.info!=pj.info){
                return false;
            }
        }
        return true;
    }
}
