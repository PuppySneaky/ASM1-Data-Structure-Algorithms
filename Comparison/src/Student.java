

// Class representing a single student
class Student {
    private String studentID;
    private String studentName;
    private float marks;

    // Constructor
    public Student(String studentID, String studentName, float marks) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public float getMarks() {
        return marks;
    }

    // Setters
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    // Get rank based on marks
    public String getRank() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // String representation of a student
    @Override
    public String toString() {
        return "ID: " + studentID +
                ", Name: " + studentName +
                ", Marks: " + marks +
                ", Rank: " + getRank();
    }
}