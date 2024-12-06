// Node class for the stack
class Node {
    Student student;
    Node next;

    // Constructor to initialize a node with a student
    public Node(Student student) {
        this.student = student;
        this.next = null;
    }
}