public class ListNode {
    int val;
    ListNode next;
    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return Integer.toString(val);
    }
    public static void main(String[] args) {
        ListNode node = new ListNode();
        System.out.println(node);
    }
}
