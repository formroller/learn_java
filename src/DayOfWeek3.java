import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class DayOfWeek3 {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private HashMap<Date, String> planMap;

    public DayOfWeek3() {//생성자
        planMap = new HashMap<Date, String>();
    }

    /**
     * @param date ex: "2017-06-20"
     * @param plan
     * @thorws ParseException
     */
    // 일정 등록
    public void registerPlan(String strDate, String plan) {
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//        System.out.println(date);
        try {
            SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date date = dayFormat.parse(strDate);
            //System.out.println(date);
            planMap.put(date, plan);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    // 일정 검색
    public String searchPlan(String strDate) {
        String plan = null;
        try {
            SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date date = dayFormat.parse(strDate);
            plan = planMap.get(date);
            return plan;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plan;
    }
    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month];
        } else {
            return MAX_DAYS[month];
        }
    }

    /**
     * - 1일의 요일을 입력받는다.
     * - 출력한다.
     */
    public void printCalendar(int year, int month) {
        System.out.printf("   <<%4d년 %3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        //get weekday atuomatically
        int weekday = getWeekDay(year, month, 1);
        // print blank space
        for (int i = 0; i < weekday; i++) {
            System.out.print("   ");
        }

        int maxDay = getMaxDaysOfMonth(year, month);
        int count = 7 - weekday;
        int delimeter = (count < 7) ? count : 0; // 삼항연산자-(조건문)?참:거짓; [참고]https://coding-factory.tistory.com/266

        //print first line
        for (int i = 1; i <= count; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        //print second to last line
        count++;
        for (int i = count; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == delimeter) {
                System.out.println();
            }
        }
        System.out.println();

    }

    private int getWeekDay(int year, int month, int day) {
        int syear = 1970;
        int smonth = 1;
        int sday = 1;
        final int STANDARD_WEEKDAY = 4; //1970-Jan-1st = Thursday

        int count = 0;

        for (int i = syear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }

//        System.out.println(count);
        for (int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonth(year, i);
            count += delta;
        }
        count += day - 1;

        int weekday = (count + STANDARD_WEEKDAY) % 7; // 요일 계산
        return weekday;
    }

    //simple test code
    public static void main(String[] args) {
        DayOfWeek3 cal = new DayOfWeek3();
        cal.getWeekDay(1970, 5, 1);
        System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
        System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
        System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
        System.out.println(cal.getWeekDay(1973, 1, 1) == 1);
        System.out.println(cal.getWeekDay(1974, 1, 1) == 2);
        cal.registerPlan("2017-06-23", "Let's learn anything!");
        System.out.println(cal.searchPlan("2017-06-23").equals("Let's learn anything!"));
    }
}


//try - catch문 학습 필요(예외처리)
//[참고]https://rural-mouse.tistory.com/75