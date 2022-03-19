import java.util.HashMap;
class Node{
    int key,value;
    Node prev , next ;
}
class LRUCache{
    private HashMap< Integer , Node > cache ;
    int capacity , current_size = 0 ; 
    Node head , tail ; 

    LRUCache(int capacity){
        this.capacity = capacity ;
        cache = new HashMap<>();
        head  = new Node();
        tail  = new Node();
        head.next = tail ;
        tail.prev = head ;
    }

    private void add(Node curr){
        curr.next = head.next ;
        head.next.prev = curr ;
        curr.prev = head ;
        head.next = curr ;
    }

    private void remove(Node curr){
        curr.prev.next = curr.next ;
        curr.next.prev = curr.prev ;
    }

    private void moveToHead(Node curr){
        remove(curr);
        add(curr);
    }

    public void put(int key , int val){
        Node address = cache.getOrDefault(key , null ) ;
        if(address == null){
            if(current_size == capacity){
                remove(tail.prev);
                cache.remove(key);
                --current_size ;
            }
            Node new_Node = new Node();
            new_Node.key   = key ;
            new_Node.value = val ;
            cache.put( key , new_Node) ;
            add(new_Node);
            ++current_size ;
        }
        else{
            moveToHead(address);
        }
    }

    public int get(int key){
        Node address  = cache.getOrDefault(key , null ) ;
        if(address == null){
            return -1 ;
        }
        moveToHead(address);
        return address.value ;
    }
}
class Main{
    public static void main(String args[]){
        LRUCache myCache = new LRUCache(3);
        myCache.put(1,1);
        myCache.put(2,2);
        myCache.put(3,3);
        System.out.println("1: " + myCache.get(2));
        myCache.put(4,10);
        System.out.println("2: " + myCache.get(1));
        System.out.println("3: " + myCache.get(4));
    }
}