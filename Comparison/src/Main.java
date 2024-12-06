import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();

        // Generate students
        int studentCount = 10000;
        Random random = new Random();
        for (int i = 1; i <= studentCount; i++) {
            String studentID = "ID" + i;
            String studentName = "Student" + i;
            float marks = 1.0f + random.nextFloat() * 9.0f; // Random marks between 1.0 and 10.0
            studentStack.push(new Student(studentID, studentName, marks));
        }

        System.out.println(studentCount + " students added to the stack.");

        // Measure Merge Sort runtime
        long startMergeSort = System.nanoTime();
        studentStack.sortStudents();
        long endMergeSort = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endMergeSort - startMergeSort) + " ns");

        // Measure Bubble Sort runtime
        // Re-add the same 10,000 students for Bubble Sort to ensure same input
        StudentStack studentStackForBubbleSort = new StudentStack();
        for (int i = 1; i <= studentCount; i++) {
            String studentID = "ID" + i;
            String studentName = "Student" + i;
            float marks = 1.0f + random.nextFloat() * 9.0f; // Random marks between 1.0 and 10.0
            studentStackForBubbleSort.push(new Student(studentID, studentName, marks));
        }

        long startBubbleSort = System.nanoTime();
        studentStackForBubbleSort.bubbleSortStudents();
        long endBubbleSort = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endBubbleSort - startBubbleSort) + " ns");
    }
}