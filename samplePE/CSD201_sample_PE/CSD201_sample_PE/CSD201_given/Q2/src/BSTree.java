/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
         if(xOwner.charAt(0)=='B'||xPrice>100) return;
         insert(new Car(xOwner, xPrice));
     }
public void insert(Car x){
	 Node q=new Node(x);
     if(isEmpty())
      {root=q;
        return;
       }
     Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.price == x.price)
          {
            return;
          }
         f=p;
         if(x.price < p.info.price) p=p.left; else p=p.right;
       } 
      if(x.price< f.info.price) f.left=q; else f.right=q;
    } 
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f);


    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  
     void preOrder2(Node p, RandomAccessFile f) throws Exception{
	 if(p==null) return;
     if(p.info.price>=3&&p.info.price<=5){
        fvisit(p,f);
     }
     preOrder2(p.left,f);
     preOrder2(p.right,f);
   }
// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
  void f3() throws Exception
    {clear();
     loadData(7);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        deleteByCopy(findNodeWithTwoChildren(root));

    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }
  //Xoa mot node bat ki 
  public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while (q != null) {
            if(q.info.equals(p.info)) break;
            f=q;
            if (q.info.owner.compareTo(p.info.owner) > 0) {         // Changed
                q = q.left;
            } else {
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        } // 2. p has a left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {// remove root
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } // 3. p has a right child only
        else if (p.right != null && p.left == null) {
            if (f == null) {// remove root
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        } // 4. Both of right and left child 
        else if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {// rp has no right child 
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }
    Node findNodeWithTwoChildren(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) {
            return null;
        }
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null && node.right != null && node.info.price < 7) {
                return node;
            } else {
                if (node.left != null) {
                    queue.enqueue((node.left));
                }
                if (node.right != null) {
                    queue.enqueue((node.right));
                }
            }
        }
        return null;
    }
//=============================================================
  void f4() throws Exception
    {clear();
     loadData(10);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        rotateModifier(findNodeWithLeftChildren(root));


    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
    Node findNodeWithLeftChildren(Node p) throws Exception {
        Queue queue = new Queue();
        if (isEmpty()) {
            return null;
        }
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node.left != null) {
                if (node.info.price < 7) {
                    return node;
                } else {
                    queue.enqueue((node.left));
                }
            }
            if (node.right != null) {
                queue.enqueue((node.right));
            }
        }
        return null;
    }
           public void rotateModifier(Node node){
        Node nodeRotate = rotateRight(node);
		Node nodeFather = father(node.info.price);
		if(nodeFather==null) root = nodeRotate;
        else{
			if(nodeFather.left==node) nodeFather.left = nodeRotate; 
			else  nodeFather.right = node;
         }
	}

        public Node rotateRight(Node p){
        if(p.left == null){
            return p;
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
            Node father(int xPrice){
	 Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.price == xPrice) break;
         f=p;
         if(xPrice < p.info.price)  p=p.left; else p=p.right;
       }
     return(f);
    }
 }
