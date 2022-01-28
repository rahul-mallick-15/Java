import java.util.*;
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
    void displayList(Node head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    Node reverseList(Node head){
        Node curr = head , prev = null , next = null ;
        while(curr != null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        head = prev ;
        return head ;
    }
    public Node reverseList(Node curr , int k){
        //This function assumes the list has atleast k nodes
        Node last = null , next = null;
        while(k-- > 0){
            next = curr.next ;
            curr.next = last ;
            last = curr ;
            curr = next ;
        } 
        return last ;
    }
    Node reverseKGroup(Node head, int k){
        Node new_head = head , ptr = head , ktail = null;
        while(ptr != null){
            int count = 0 ;
            while(count < k && ptr != null){
                ++count ;
                ptr = ptr.next ;
            }
            if(count == k){
                Node rev_head = reverseList(head , k );
                if(ktail != null ){
                    ktail.next = rev_head ;
                }
                else{
                    new_head = rev_head ;
                }
                ktail = head ;
                head = ptr ;
            }
        }
        if(ktail != null){
            ktail.next = head ;
        }
        return new_head ;
    }
}
class Mains{
    public static void main(String args[]){
        int input[] = new int[]{1 , 2 ,3 ,4 ,5 ,6 , 7, 8} ;

        Node curr = new Node(input[0]) , head = curr ;
        for(int i = 1 ; i < input.length ;++i){
            curr.next = new Node(input[i]);
            curr = curr.next;
        }

        head.displayList(head);
        head = head.reverseList(head);
        head.displayList(head);
        head.displayList(head.reverseKGroup(head.reverseList(head), 3)) ;
    }
}