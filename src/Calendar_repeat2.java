import java.util.Scanner;

public class Calendar_repeat2 {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    /**
     * - 월을 입력하면 해당월의 달력 출력.
     * - 달력 모양은 printCalendar 모양으로 생성.
     * - 1일은 일요일로 정해도 무방.
     * - -1 입력받기 전까지 반복한다.
     * - 프롬프트 출력.
     */

    public void printCalendar(int year, int month) {
        System.out.printf("   <<%4d년 %3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("--------------------");

        int maxDay = getMaxDaysOfMonth(month);

        for (int i = 1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

//        System.out.println(" 1  2  3  4  5  6  7");
//        System.out.println("8  9  10 11 12 13 14");
//        System.out.println("15 16 17 18 19 20 21");
//        System.out.println("22 23 24 25 26 27 28");
    }


}
