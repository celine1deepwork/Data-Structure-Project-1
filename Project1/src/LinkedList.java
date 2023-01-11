public class LinkedList {
    Node first, last;
    LinkedList list;
    Node temp;
    Node temp2;

    public LinkedList(){
        first= null;
        last= null;
        temp = first;

    }


    public void insertFirst(Node newNode) { // ...

        if (this.last == null) {
            this.last= newNode;
        }

        newNode.next = first;
        this.first = newNode;

    }

    public void insertLast(Node temp) {
        if (this.last == null) {
            this.last = temp;
        }
        this.last.next = temp;
        this.last = temp;
    }

    public void getList( ){
        this.temp = this.first;
        while(temp != null){
            System.out.print(this.temp.coefficient+ "x^" + this.temp.degree+ " + ");
            this.temp = temp.next;
        }
    }

    public void deleteNode(Node node){
        this.temp =list.first;
        while(temp !=null){
            if(node == temp.next){
                temp.next = node.next;
                node = null;

            }
            temp = temp.next;
        }
    }
    public int findIndexNode(Node node){
        Node temp = first;
        int count=0;
        while(temp != null){
            if(node.equals(temp)){
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void deleteNode(int data){
        Node temp = first;
        Node prev = null;
        if (temp != null && temp.data == data) {
            first = temp.next;
            return;
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;

        prev.next = temp.next;
    }



    public String sort(){
        LinkedList lSort = new LinkedList();
        Node t1 = this.first;
        Node t2 ;
        while(t1 != null){
             t2 = this.first.next;
            while(t2 != null){
                if(t2.degree > t1.degree){
                    lSort.insertLast(t2);
                }
                t2 = t2.next;
            }
            t1 = t1.next;
        }
       // System.out.println("List is Sorted: ");
       //  lSort.getList();
        return "List is Sorted.";

    }


}

