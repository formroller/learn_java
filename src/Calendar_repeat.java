import java.util.Calendar;
import java.util.Scanner;

public class Calendar_repeat {
    private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};

    public int getMaxDaysOfMonth(int month){return MAX_DAYS[month - 1];}

//    public void printSampleCalendar(){
//        System.out.println("일 월 화 수 목 금 토");
//        System.out.println("-----------------");
//        System.out.println("1 2 3 4 5 6 7");
//        System.out.println("8 9 10 11 12 13 14");
//        System.out.println("15 16 17 18 19 20 21");
//        System.out.println("22 23 24 25 26 27 28");
//    }

    // 반복 횟수 알때 사용
//    public static void main(String[] args){
//        // 숫자 입력받아 해당하는 달의 최대 일 수 출력하는 프로그램 생성
//        String PROMPT="cal> ";
//        Scanner scanner = new Scanner(System.in);
//        calender cal = new calender();
//
//
//        // n번 반복 가능하도록 프로그램 변경
//        System.out.println("반복 횟수 : ");
//        int repeat = scanner.nextInt();
//
//        for (int i=0; i<repeat; i++){
//            System.out.println("달을 입력하시오");
//            System.out.print(PROMPT);
//            int month = scanner.nextInt();
//            System.out.printf("%d월은 %d일까지 있습니다.",month, cal.getMaxDaysOfMonth(month));
//        }
//        System.out.println("End.");
//        scanner.close();
//
//    }
    // 반복 횟수 모를때
    public static void main(String[] args){
        String PROMPT = "cal> ";
        Scanner scanner = new Scanner(System.in);
        calender cal = new calender();

        int month=1;
        while (true){
            System.out.println("달을 입력하시오");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if (month==-1){
                break;
            }
            if (month > 12){
                continue;
            }
            System.out.printf("%d월은 %d일까지 있습니다.",month, cal.getMaxDaysOfMonth(month));
            }
        System.out.println("End.");
        scanner.close();
    }
}
