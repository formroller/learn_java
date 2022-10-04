import java.util.Scanner;

public class prompt {
    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar_repeat2 cal = new Calendar_repeat2();

        int month = 1;

        while (true) {
            System.out.println("달을 입력하시오");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if (month == -1) {
                break;
            }
            if (month > 12) {
                continue;
            }
            cal.printCalendar(2022, month);
        }
        System.out.println("End.");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        prompt p = new prompt();
        p.runPrompt();
    }
}
