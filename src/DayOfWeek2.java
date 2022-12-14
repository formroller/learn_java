public class DayOfWeek2 {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
        int weekday=getWeekDay(year, month, 1);
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
    private int getWeekDay(int year,int month,int day){
        int syear = 1970;
        int smonth=1;
        int sday=1;
        final int STANDARD_WEEKDAY=4; //1970-Jan-1st = Thursday

        int count = 0;

        for (int i=syear; i< year; i++){
            int delta = isLeapYear(i) ? 366 : 365;
            count +=delta;
        }

//        System.out.println(count);
        for (int i=1; i< month; i++){
            int delta=getMaxDaysOfMonth(year, i);
            count += delta;
        }
        count += day - 1 ;

        int weekday = (count+STANDARD_WEEKDAY) % 7 ; // 요일 계산
        return weekday;
    }
    //simple test code
    public static void main(String[] args){
      DayOfWeek2 cal = new DayOfWeek2();
      cal.getWeekDay(1970,5, 1);
      System.out.println(cal.getWeekDay(1970,1,1)==3);
      System.out.println(cal.getWeekDay(1971,1,1)==4);
      System.out.println(cal.getWeekDay(1972,1,1)==5);
      System.out.println(cal.getWeekDay(1973,1,1)==0);
      System.out.println(cal.getWeekDay(1974,1,1)==1);
    }
}
