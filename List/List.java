public class List {
    ListNode head;
    int size;

    public void add(int val) {
        if (head != null) {

            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(val);

        } else {

            head = new ListNode(val);

        }
        size++;
    }

    public void remove (int val) {
        if (head == null) return;

        if (val != head.val) {
            ListNode last = head, curr = head.next;
            while (curr != null) {
                if (curr.val == val) {
                    last.next = curr.next;
                    size--;
                    break;
                }
                last = curr;
                curr = curr.next;
            }
        } else {
            head = head.next;
            size--;
        }
    }


    @Override
    public String toString() {
        if (head == null) return null;

        StringBuilder str = new StringBuilder();
        ListNode curr = head;
        while (curr.next != null) {
            str.append(curr.toString() + "-->");
            curr = curr.next;
        }
        str.append(curr.toString());

        return str.toString();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        List myList = new List();
        System.out.println(myList);    //toString head == null
        System.out.println(myList.isEmpty());

        myList.remove(0); //remove head == null
        System.out.println(myList);

        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        System.out.println(myList);    //normal case

        myList.remove(1); //remove non-head node
        System.out.println(myList);

        myList.remove(0);      //remove head
        System.out.println(myList);

        myList.remove(0);   //remove non-exist node
        System.out.println(myList);

        System.out.println(myList.getSize());
        System.out.println(myList.isEmpty());
    }



}
