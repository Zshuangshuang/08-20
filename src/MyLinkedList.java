/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-08-19
 * Time:20:59
 **/
class Node{
    private Node next;
    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node( int data) {
        this.next = null;
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = head;
    }
    public void addFirst(int data){
        Node node = new Node(data);

        if (this.head == null){
            this.head = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public boolean isContains( int toFind){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == toFind){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return  count;
    }
    public Node findPrev(int index){
        Node prev = this.head;
        while (index-1 >0 ){
            prev = prev.getNext();
            index--;
        }
        return prev;
    }
    public void addIndex(int pos, int data){
        if (pos < 0 || pos >size()){
            return;
        }
        if (pos == 0){
            addFirst(data);
            return;
        }
        if (pos == size()){
            addLast(data);
            return;
        }
        Node prev = findPrev(pos);
        Node node = new Node(data);
        node.setNext(prev.getNext());
        prev.setNext(node);
    }
    public Node findToRemove(int toRemove){
        Node prev = this.head;
        while(prev != null){
            if (prev.getNext().getData() == toRemove && prev.getNext() != null){
                return prev;
            }
            prev = prev.getNext();
        }
        return null;
    }
    public void remove(int toRemove){
        if (this.head == null){
            return;
        }
        if (this.head.getData() == toRemove){
            this.head = this.head.getNext();
            return;
        }
        Node prev = findToRemove(toRemove);
        if (prev == null){
            return;
        }
        Node del = prev.getNext();
        prev.setNext(del.getNext());
    }
    public void removeAllKey(int toRemove){
        Node cur= this.head;
        Node curNext = this.head.getNext();
        while (curNext != null){
            if (curNext.getData() == toRemove){
                cur.setNext(curNext.getNext());
                curNext = cur.getNext();
            }else {
                cur = curNext;
                curNext = curNext.getNext();
            }
        }
        if (this.head.getData() == toRemove){
            this.head = this.head.getNext();
        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addLast(10);
        myLinkedList.addLast(50);
        myLinkedList.addLast(10);
        myLinkedList.display();
       /* System.out.println(myLinkedList.isContains(10));
        myLinkedList.addIndex(1,20);
        myLinkedList.display();
        myLinkedList.remove(20);
        myLinkedList.display();*/
        myLinkedList.removeAllKey(10);
        myLinkedList.display();
    }
}

