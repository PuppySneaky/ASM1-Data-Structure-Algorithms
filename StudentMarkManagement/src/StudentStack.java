// Stack implementation using linked list with Merge Sort
class StudentStack {
    private Node top; // Top of the stack

    // Constructor to initialize an empty stack
    public StudentStack() {
        this.top = null;
    }

    // Push a new student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        System.out.println("Added: " + student.getStudentName());
    }

    // Pop the top student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No student to remove.");
            return null;
        }
        Student removedStudent = top.student;
        top = top.next;
        System.out.println("Removed: " + removedStudent.getStudentName());
        return removedStudent;
    }

    // Peek at the top student without removing
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return top.student;
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
        System.out.println("Students sorted by marks.");
    }

    // Merge Sort helper function
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        // Recursively sort each half
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Function to merge two sorted lists
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
        } else if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    // Helper function to find the middle of the linked list
    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Search for a student by ID
    public Student searchStudent(String studentID) {
        Node current = top;
        while (current != null) {
            if (current.student.getStudentID().equals(studentID)) {
                return current.student;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + studentID + " not found.");
        return null;
    }

    // Edit a student's details
    public void editStudent(String studentID, String name, float marks) {
        Student student = searchStudent(studentID);
        if (student != null) {
            student.setStudentName(name);
            student.setMarks(marks);
            System.out.println("Updated details for student ID: " + studentID);
        }
    }

    // Delete a student by ID
    public void deleteStudent(String studentID) {
        if (isEmpty()) {
            System.out.println("Stack is empty. No student to delete.");
            return;
        }

        if (top.student.getStudentID().equals(studentID)) {
            pop();
            return;
        }

        Node current = top;
        while (current.next != null && !current.next.student.getStudentID().equals(studentID)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Deleted student with ID: " + studentID);
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }
}
