import java.util.Scanner;

public class UpdatingLinkedList extends DoublyLinkedList<Long> {

    public void insertNumber(long number) {
        Node<Long> trav = tail;
        if (head == null || head.data >= number) {
            addFirst(number);
        } else if (tail.data <= number) {
            addLast(number);
        } else {
            while (trav.data > number) {
                trav = trav.prev;
            }
            Node<Long> num = new Node<>(number, trav, trav.next);
            trav.next.prev = num;
            trav.next = num;
        }
    }

    public static void main(String[] args) {
        var autoUpdater = new UpdatingLinkedList();
        Scanner sc = new Scanner(System.in);

        for (int num = sc.nextInt(); num > 0; num--) {
            autoUpdater.insertNumber(sc.nextLong());
        }

        System.out.println(autoUpdater);
    }
}
