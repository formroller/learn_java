import java.util.Scanner;

public class prompt2 {

    public int parseDay(String week){
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
        DayOfWeek cal = new DayOfWeek();

        int month = 1;
        int year = 2017;
        int weekday = 0;

        while (true) {
            System.out.println("연도를 입력하시오.(exit:-1)");
            System.out.print("Year> ");
            year = scanner.nextInt();
            if (year == -1)
                break;

            System.out.println("달을 입력하시오.");
            System.out.print("Month> ");
            month = scanner.nextInt();

            System.out.println("첫 째 날의 요일을 입력하시오.[su mo tu wd th fr sa]");
            System.out.print("WeekDay> ");
            String str_weekday = scanner.next();
            weekday = parseDay(str_weekday);


            if (month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            cal.printCalendar(year, month, weekday);
        }
        System.out.println("End.");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        prompt2 p = new prompt2();
        p.runPrompt();
    }
}
