public class Teacher {

    public void teach(Student student, String teach) {
        student.learn(teach);
    }

    public void answer(String question) {

        System.out.println("answer to " + question + " answer");
    }

    public static void main(String[] args) {

        Teacher teacher = new Teacher();

        Student student = new Student();
        student.question(teacher,"question");
        teacher.teach(student, "teach");
    }






//    Create Student and Teacher classes
//            Student
//    learn()
//    question(teacher) -> calls the teachers answer method
//            Teacher
//    teach(student) -> calls the students learn method
//    answer()
}