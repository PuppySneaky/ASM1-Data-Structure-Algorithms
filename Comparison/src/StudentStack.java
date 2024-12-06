// Stack implementation using linked list
class StudentStack {
    private Node top;

    // Constructor
    public StudentStack() {
        this.top = null;
    }

    // Push a new student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display all students in the stack
    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        Node current = top;
        System.out.println("Students in the stack:");
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    // Sort students using Merge Sort
    public void sortStudents() {
        top = mergeSort(top);
    }

    // Merge Sort helper function
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    // Merge two sorted lists
    private Node merge(Node left, Node right) {
        Node dummy = new Node(null);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.student.getMarks() <= right.student.getMarks()) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }

    // Get the middle of the linked list
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Sort students using Bubble Sort
    public void bubbleSortStudents() {
        if (top == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = top;
            while (current != null && current.next != null) {
                if (current.student.getMarks() > current.next.student.getMarks()) {
                    // Swap students
                    Student temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}