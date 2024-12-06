public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();

        // Add students to the stack
        studentStack.push(new Student("101", "Alice", 8.5f));
        studentStack.push(new Student("102", "Bob", 6.0f));
        studentStack.push(new Student("103", "Charlie", 4.5f));

        // Display all students
        studentStack.displayStudents();

        // Sort and display students
        studentStack.sortStudents();
        studentStack.displayStudents();

        // Edit a student
        studentStack.editStudent("102", "Bobby", 7.0f);
        studentStack.displayStudents();

        // Delete a student
        studentStack.deleteStudent("103");
        studentStack.displayStudents();

        // Search for a student
        Student foundStudent = studentStack.searchStudent("101");
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent);
        }
    }
}