import java.util.*;

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

        // 4️⃣ 建立多位學生（保留既有樣本）
        List<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Alice"));
        students.add(new Student("S002", "Bob"));
        students.add(new Student("S003", "Carol"));
        students.add(new Student("S004", "David"));
        students.add(new Student("S005", "Eve"));

        Scanner scanner = new Scanner(System.in);

        // 先處理現有（樣本）學生，使用預設模擬答案
        for (int idx = 0; idx < students.size(); idx++) {
            Student student = students.get(idx);
            ExamSession session = new ExamSession(exam, student);

            // 依學生不同給予不同答案樣本（使用 index 而不是 ID，方便動態輸入）
            switch (idx) {
                case 0: // 第一位: Alice-like
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 全對
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Garbage Collection"))); // 部分對
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 正確
                    session.submitAnswer(q4, new TextAnswer(" new ")); // 忽略空白
                    session.submitAnswer(q5, new PendingAnswer()); // 待人工評分
                    break;
                case 1: // 第二位: Bob-like
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("No")));
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Platform Independent")));
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false")));
                    session.submitAnswer(q4, new TextAnswer("new"));
                    session.submitAnswer(q5, new TextAnswer("Polymorphism means objects can take many forms."));
                    break;
                case 2: // 第三位: Carol-like
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes")));
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("Platform Independent")));
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("true")));
                    session.submitAnswer(q4, new TextAnswer("create"));
                    session.submitAnswer(q5, new PendingAnswer());
                    break;
                case 3: // 第四位: David-like (no answers)
                    break;
                case 4: // 第五位: Eve-like
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes")));
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Platform Independent")));
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false")));
                    session.submitAnswer(q4, new TextAnswer("new"));
                    session.submitAnswer(q5, new TextAnswer("多型是同一介面不同實作的行為"));
                    break;
                default: // 其他輸入的學生使用一組簡單答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes")));
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP")));
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false")));
                    session.submitAnswer(q4, new TextAnswer("new"));
                    session.submitAnswer(q5, new PendingAnswer());
                    break;
            }

            // 計算成績並列印
            double totalScore = session.calculateScore();
            GradeReport report = new GradeReport(student, totalScore);

            System.out.println("===== Exam Result =====");
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student: " + student.getName());
            System.out.println("Total Score: " + totalScore);
            System.out.println(report.getSummary());
            System.out.println();
        }

        // 現有學生處理完畢後，再詢問使用者是否要新增互動學生並作答
        System.out.print("是否要新增互動學生並讓其作答？(y/n)：");
        String addChoice = scanner.nextLine().trim().toLowerCase();
        if (addChoice.equals("y") || addChoice.equals("yes")) {
            System.out.print("要新增幾位互動學生？輸入數字：");
            int addCount = 0;
            try {
                addCount = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                addCount = 0;
            }
            for (int i = 0; i < addCount; i++) {
                System.out.println("---- 新增學生 " + (i + 1) + " ----");
                System.out.print("輸入學生學號 (ID)：");
                String id = scanner.nextLine().trim();
                if (id.isEmpty()) id = "I" + String.format("%03d", i + 1);
                System.out.print("輸入學生姓名 (Name)：");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) name = "InteractiveStudent" + (i + 1);
                Student s = new Student(id, name);

                // 建立 session 並逐題收集答案
                ExamSession session = new ExamSession(exam, s);
                System.out.println("請為學生 " + name + " 作答 (輸入 p 表示待人工評分，留空代表略過)：");
                for (Question q : exam.getQuestions()) {
                    System.out.println();
                    System.out.println(q.id + ": " + q.content + " (分數: " + q.getScore() + ")");

                    if (q instanceof SingleChoiceQuestion) {
                        System.out.print("[單選] 請輸入你的答案 (單一選項)：");
                        String ans = scanner.nextLine().trim();
                        if (ans.equalsIgnoreCase("p")) {
                            session.submitAnswer(q, new PendingAnswer());
                        } else if (ans.isEmpty()) {
                            session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet()));
                        } else {
                            session.submitAnswer(q, new ChoiceAnswer(Set.of(ans)));
                        }

                    } else if (q instanceof MultipleChoiceQuestion) {
                        System.out.print("[多選] 請輸入以逗號分隔的選項，例如: OOP,Platform Independent：");
                        String line = scanner.nextLine().trim();
                        if (line.equalsIgnoreCase("p")) {
                            session.submitAnswer(q, new PendingAnswer());
                        } else if (line.isEmpty()) {
                            session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet()));
                        } else {
                            String[] parts = line.split(",");
                            Set<String> set = new LinkedHashSet<>();
                            for (String p : parts) {
                                String t = p.trim();
                                if (!t.isEmpty()) set.add(t);
                            }
                            session.submitAnswer(q, new ChoiceAnswer(set));
                        }

                    } else if (q instanceof TrueFalseQuestion) {
                        System.out.print("[是非] 請輸入 true/false (或 y/n)：");
                        String line = scanner.nextLine().trim();
                        if (line.equalsIgnoreCase("p")) {
                            session.submitAnswer(q, new PendingAnswer());
                        } else if (line.isEmpty()) {
                            session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet()));
                        } else {
                            session.submitAnswer(q, new ChoiceAnswer(Set.of(line)));
                        }

                    } else if (q instanceof FillInBlankQuestion) {
                        System.out.print("[填空] 請輸入答案：");
                        String line = scanner.nextLine();
                        if (line.trim().equalsIgnoreCase("p")) {
                            session.submitAnswer(q, new PendingAnswer());
                        } else if (line.trim().isEmpty()) {
                            session.submitAnswer(q, new TextAnswer(""));
                        } else {
                            session.submitAnswer(q, new TextAnswer(line));
                        }

                    } else if (q instanceof ShortAnswerQuestion) {
                        System.out.print("[簡答] 請輸入答案 (此類題目通常需人工評分)：");
                        String line = scanner.nextLine();
                        if (line.trim().equalsIgnoreCase("p")) {
                            session.submitAnswer(q, new PendingAnswer());
                        } else if (line.trim().isEmpty()) {
                            session.submitAnswer(q, new TextAnswer(""));
                        } else {
                            session.submitAnswer(q, new TextAnswer(line));
                        }

                    } else {
                        // fallback
                        System.out.print("[未知題型] 請輸入答案：");
                        String line = scanner.nextLine();
                        session.submitAnswer(q, new TextAnswer(line));
                    }
                }

                // 計算成績並列印
                double totalScore = session.calculateScore();
                GradeReport report = new GradeReport(s, totalScore);

                System.out.println("===== Exam Result =====");
                System.out.println("Student ID: " + s.getId());
                System.out.println("Student: " + s.getName());
                System.out.println("Total Score: " + totalScore);
                System.out.println(report.getSummary());
                System.out.println();
            }
        }

        scanner.close();
    }
}
