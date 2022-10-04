import java.util.Scanner;

// 요일 입력받지 않음.
public class prompt3 {

    public int parseDay(String week) {
        /**
         * @param week 요일명
         * @return 0-6 (0=su 6=sa)
         */
        if (week.equals("su")) return 0;
        else if (week.equals("mo")) return 1;
        else if (week.equals("tu")) return 2;
        else if (week.equals("we")) return 3;
        else if (week.equals("th")) return 4;
        else if (week.equals("fr")) return 5;
        else if (week.equals("sa")) return 6;
        else
            return 0;
    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        DayOfWeek2 cal = new DayOfWeek2();

        int month = 1;
        int year = 2017;

        while (true) {
            System.out.println("연도를 입력하시오.(exit:-1)");
            System.out.print("Year> ");
            year = scanner.nextInt();
            if (year == -1)
                break;

            System.out.println("달을 입력하시오.");
            System.out.print("Month> ");
            month = scanner.nextInt();

            if (month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            cal.printCalendar(year, month);
        }
        System.out.println("End.");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        prompt3 p = new prompt3();
        p.runPrompt();
    }
}
