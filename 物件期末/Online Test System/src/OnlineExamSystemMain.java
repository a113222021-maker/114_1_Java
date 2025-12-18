import java.util.Set;

public class OnlineExamSystemMain {

    public static void main(String[] args) {

        // 1️⃣ 建立考試
        Exam exam = new Exam("OOP Online Exam");

        // 2️⃣ 建立題目
        Question q1 = new SingleChoiceQuestion(
                "Q1",
                "Java 是物件導向語言嗎？",
                10,
                "Yes"
        );

        Question q2 = new MultipleChoiceQuestion(
                "Q2",
                "以下哪些是 Java 的特性？",
                20,
                Set.of("OOP", "Platform Independent")
        );

        Question q3 = new TrueFalseQuestion(
                "Q3",
                "Java 支援多重繼承。",
                10,
                false
        );

        Question q4 = new FillInBlankQuestion(
                "Q4",
                "Java 的關鍵字，用來建立物件的是？",
                10,
                Set.of("new")
        );

        Question q5 = new ShortAnswerQuestion(
                "Q5",
                "請簡述什麼是多型（Polymorphism）？",
                20
        );

        // 3️⃣ 加入考試
        exam.addQuestion(q1);
        exam.addQuestion(q2);
        exam.addQuestion(q3);
        exam.addQuestion(q4);
        exam.addQuestion(q5);

        // 4️⃣ 建立學生
        Student student = new Student("S001", "Alice");



        // 5️⃣ 開始考試作答
        ExamSession session = new ExamSession(exam, student);

        session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 全對
        session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Garbage Collection"))); // 部分對
        session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 正確
        session.submitAnswer(q4, new TextAnswer(" new ")); // 忽略空白
        session.submitAnswer(q5, new PendingAnswer()); // 待人工評分

        // 6️⃣ 計算成績
        double totalScore = session.calculateScore();

        // 7️⃣ 成績報告
        GradeReport report = new GradeReport(student, totalScore);

        System.out.println("===== Exam Result =====");
        System.out.println("Student: " + student.getName());
        System.out.println("Total Score: " + totalScore);
        System.out.println(report.getSummary());
    }
}

