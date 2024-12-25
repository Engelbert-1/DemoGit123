　||____ADD______//add last
 ||	||______//add first
 ||     ||______//add many
 ||     ||______//add if age > 4
 ||     ||______//add element have max age
 ||     ||______//add a node with value x after the node p
 ||
 ||___INSERT____//insert index k
 ||       ||____//insert after index k
 ||       ||____//insert before index k
 ||       ||____//insert x to sorted link list
 ||
 ||___SEARCH____//search node with Object
 ||       ||____//search node with string
 ||       ||____//search node with integer/double
 ||       ||____//search node with index
 ||       ||____//search node after index
 ||       ||____//search node before index
 ||       ||____//search first node have integer/double/string(VD:first node have age=5)
 ||       ||____//search second node have integer/double/string(VD:second node have age=5)
 ||
 ||___DELETE____//delete node
 ||       ||____//delete all
 ||       ||____//delete 2 node last have age > 5
 ||       ||____// Delete from head
 ||       ||____// Delete from tail
 ||       ||____// Delete after a given node p
 ||___SORT______
 ||     ||______//sort by for assending (integer)
 ||     ||______//sort by for assending (string)
 ||     ||______//sort 3 first element assending (integer)
 ||     ||______//sort 3 last element assending (integer)
 ||     ||______//sort between index 2 to 6 element assending (integer)
 ||     ||______//check sorted accending?
 ||
 ||___SWAP______//swap min max
 ||     ||______//swap node max second with node min first
 ||
 ||___GET_______//get index at Node
 ||    ||_______//get Object max
 ||    ||_______//get Object max second
 ||
 ||___ORTHER____//traverse
 ||       ||____//replace a node
 ||       ||____//count number of node
 ||       ||____//reverse list
 ||       ||____//append another list
 ||       ||____//change name first
 ||       ||____//convert to array[]
 ||       ||____//Check 2 link list equal
 
//add last
    public void addLast(Person x){
        Node q = new Node(x);
        if(isEmpty()){head=tail=q;return;}
        tail.next=q;tail=q;
    }
	
//add first
    public void addFirst(Person x){
		Node p = new Node(x);
		if(isEmpty()) {head = tail = p;}
		else {p.next = head; head = p;}
    }
	
//add many
	public void addMany(String [] a, int [] b){
		int n,i; n=a.length;
		for(i=0;i<n;i++) addLast(new Person(a[i],b[i]));
    }
	
//add a node with value x after the node p
void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

//add if age > 4
    public void addLastCondition(){
        Node p=head;
        while(p!=null){
            if(p.info.age>4) h.addLast(p.info);
            p=p.next;
        }
    }

//add element have max age
    public void addMaxAgeInH(){
		Person k = getMaxColor();
		Node p = head;
		while(p != null){
			if(p.info.age == k.age) h.addLast(p.info);
			p = p.next;
		}
	}
	
//insert index k
public void insertAtIndexK( Ball c,int k) {
    //Index = POSITION - 1
    Node newNode = new Node(c);
    if(k==size()+1){
        return;
    }
    if (k == 0) {
        newNode.next = head;
        head = newNode;
        return;
    }

    int count = 0;
    Node p = head;

    while (p != null && count < k - 1) {
        p = p.next;
        count++;
    }

    if (count == k - 1) {
        newNode.next = p.next;
        p.next = newNode;
    } else {
        return;
    }
}

//insert x to sorted link list
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
	
//insert after index k
public void insertAfterIndexK(Ball c,int k) {
    Node newNode = new Node(c);
    if(k==size()){
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
    } else {
        return;
    }
}

//insert before index k
public void insertBeforeIndexK(Ball c,int k) {
    Node newNode = new Node(c);

    if (k == 0) {
        newNode.next = head;
        head = newNode;
        return;
    }

    int count = 0;
    Node p = head;
    Node previous = null;

    while (p != null && count < k) {
        previous = p;
        p = p.next;
        count++;
    }

    if (count == k) {
        previous.next = newNode;
        newNode.next = p;
    } else {
        return;
    }
}

	
//search node with Object
	public Node search(Ball x){
		Node p = head;
		while(p != null && p.info != x) p = p.next;
		return p;
	}
	
//search node with string
	public Node search(String colorName){
        Node p = head;
	boolean isExisted = false;
        while(p != null){
            if(p.info.name.equalsIgnoreCase(colorName)){
		isExisted = true;
                break;
            }
            p = p.next;
        }
	if(!isExisted){
		return null;
	}
        return p;
	}
	
//search node with integer/double
	public Node search(int xAge){
		Node p=head;
		while(p!=null){
			if(p.info.age == xAge) return(p);
			p=p.next;
        }
		return(null);
     }

//search node with index
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

//search node after index
public Node findNodeAfterIndex(int k) {
    if (k < 0) {
        // Vị trí index không hợp lệ, có thể trả về null hoặc xử lý khác tùy ý
        return null;
    }

    Node p = head;
    int count = 0;

    while (p != null) {
        if (count == k) {
            return p.next;
        }
        p = p.next;
        count++;
    }

    return null;
}


//search node before index
public Node findNodeBeforeIndex(int k) {
    if (k <= 0) {

        return null;
    }

    Node p = head;
    int count = 0;

    while (p != null) {
        if (count == k - 1) {
            // Tìm thấy nút ở vị trí k - 1
            return p;
        }
        p = p.next;
        count++;
    }
    return null;
}


//search first node have integer/double/string
	public Node findFirstNodeAge() {
    Node p = head;

    while (p != null) {
        if (p.info.age == 5) {
            return p;
        }
        p = p.next;
    }

    return null;
}

//search second node have integer/double/string
public Node findSecondNode() {
    Node p = head;
    int count = 0;
    while (p != null) {
        if (p.info.age == 5) {
            count++;
            if (count == 2) {
                // Tìm thấy nút thứ hai có age =5
                return p;
            }
        }
        p = p.next;
    }
    return null;
}

//delete node
	public void dele(Node q){
		Node f,p; f=null;p=head;
		while(p!=null){
			if(p==q) break;
			f=p;p=p.next;
		}
		if(p==null) return;
		if(f==null){
			head=head.next;
			if(head==null) tail=null;
			return;
		}
		f.next=p.next;
		if(f.next==null) tail=f;
	 }
	 
//delete all
	public void deleAll(int xAge){
		Node q;
		while(true){
			q = searchByAge(xAge);
			if(q==null) break;
			dele(q);
		}   
    }
	 


//delete 2 node last have age > 5
	public void removeTwoLastNodeCondition(){
		int c = 0; int sz = size();
		for(int i = sz - 1; i >= 0; i--){
			Node p = getNode(i);
			if(p.info.age > 5){
				c++;
				remove(p);
            if(c >= 2) break;
			}
		}
    }
	
   // Delete from head
    public Person deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        Person info = head.info;
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
        }
        return info;
    }

    // Delete from tail
    public Person deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        Person info = tail.info;
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
    public Person deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return null;
        }
        Node q = p.next;
        Person info = q.info;
        p.next = q.next;
        if (q == tail) { // Update tail if the deleted node was the last one
            tail = p;
        }
        return info;
    }
	
//sort by for assending (integer)
    public void sortByFor() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.price > pj.info.price) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

//sort 3 last element assending (integer)
    public void sortByFor() {
        int n = 3;
        for (int i = size()-n; i <size()-1; i++) {
            for (int j =i+1; j <size(); j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.type < pj.info.type) {
                    Ball temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
	
//sort 3 first element assending (integer)
    public void sortByFor() {
        int n = 3;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.price > pj.info.price) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
//sort between index 2 to 6 element assending (integer)
    public void sortByFor() {
        int n = 6+1;
        for (int i = 2; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.paddle > pj.info.paddle) {
                    Boat temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
//sort by for assending (string)
    public void sortByFor() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.owner.compareTo(pj.info.owner)>0) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

//check sorted accending?
  boolean sorted() 
   {if(isEmpty() || head==tail)
     {return(true);
     }
    Node f=head,p = f.next;
    while(p!=null)
     {if(p.info<f.info) return(false);
      f=p;
      p=p.next;
     }
    return(true);
   }
	
//swap min max
	public void swapMinMax(){
		Node min = getMin();
		Node max = getMax();       
        Person t = min.info;
        min.info = max.info;
        max.info = t;
	}
	
//swap node max second with node min first
	public void swapMax2Min1(){
		Node max = getMax();
		Node min = getMin();
		Node p = head;
		int count = 0;
		while(p != null){
			if(p.info.age == max.info.age) count++;
			if(count == 2) break;
			p = p.next;
		}
		Person temp;
		temp = p.info;
		p.info = min.info;
		min.info= temp;
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

//get index at Node
public int getIndex(Node nodeToFind) {
    if (nodeToFind == null) {
        // Nếu nút truyền vào là null, không có index
        return -1;
    }

    int index = 0;
    Node p = head;

    while (p != null) {
        if (p == nodeToFind) {
            return index;
        }
        p = p.next;
        index++;
    }

    // Nếu không tìm thấy nút trong danh sách, trả về -1 hoặc giá trị khác thích hợp
    return -1;
}
	
//get Object max
	public Ball getMaxPerson(){
        if(isEmpty()) return null;
        Person max = head.info;                
        Node p = head;
        while( p != null){
            if(p.info.age > max.age) max = p.info;
            p = p.next;
        }
        return max; 
    }
//get Object max second
    public Ball getSecondMaxPerson() {
        if (isEmpty()) {
            return null;
        }
        Ball maxSecond = head.info;
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.type == getMaxPerson().type) {
                maxSecond = p.info;
                count++;
                if (count == 2) {
                    return maxSecond;
                }
            }
            p = p.next;
        }
        return null;
    }

//traverse
    public void traverse(){
		MyList h=new MyList();
		Node p=head;Person x;
		while(p!=null)
			{x=p.info;h.addFirst(x);
			p=p.next;
        }
		head=h.head;tail=h.tail;
    }

//replace a node
	public void replace{
	    Node p = head;
        while(p != null){
            if(p.info.name.equals("xName")){// xName was given
                 break;
            }
            p = p.next;
        }
         if(p != null){                       
              p.info.name = yName;// yName was given
        }
	}
	
//count number of node
  public int size() 
    {Node p = head; int c = 0;
      while(p != null) {c++; p = p.next;}
      return c;
    }
	
//reverse list
	public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            Person temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
        }
    }
	
//append another list
    void appendAnotherList(MyList h){
      Node p=h.head;
         while(p!=null)
          {addLast(p.info);
            p=p.next;
      }
    }

	
//change name first
    void changeNameFirst(){
      Node p=head;
        while(p!=null)
         {if(p.info.name.equals("C6")) {p.info.name="CX";break;}
           p=p.next;
         }
	}
}

//convert to array[]
Person[] toArray() {
    int n = size();
    Person[] arr = new Person[n];
    Node p = head;
    int i = 0;
    while (p != null) {
        arr[i++] = p.info;
        p = p.next;
    }
    return arr;
}

//Check 2 link list equal
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