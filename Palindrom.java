import java.util.*;
public class Palindrom{

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void pallindrom(){
        if(head==null || head.next==null){
            System.out.print("It is Pallindrome");
        }

        //1.Find mid
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //2.Reverse Second Half
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        Node right=prev;//Because prev is now at last
        Node left=head;

        //3.Compare First Ha;f and Second Half
        while(right!=null){
            if(right.data!=left.data){
                System.out.print("Not a Pallindrome");
                break;
            }
            right=right.next;
            left=left.next;
            
        }
        System.out.print("pallindrome");
    }

    public void print(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("null");
    }

    public static void main (String args[]){
        Palindrom ll=new Palindrom();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(1);
        
        ll.print();
        ll.pallindrom();
    }

}