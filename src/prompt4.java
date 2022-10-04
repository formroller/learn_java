import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

// 일정등록 기능 추가
public class prompt4 {
    public void printMenu() {
        System.out.println("+---------------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말  q. 종료");
        System.out.println("+---------------------------+");
        // option+shift+cursor -> 다중커서
    }

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

    //+---------------------------+
    //| 1. 일정 등록
    //| 2. 일정 검색
    //| 3. 달력 보기
    //| h. 도움말  q. 종료
    //+---------------------------+
    // 명령(1,2,3,h,q)

    public void runPrompt() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        DayOfWeek3 cal = new DayOfWeek3();


        while (true) {
            System.out.println("명령(1,2,3,h,q)");
            String cmd = scanner.next();
            if (cmd.equals("1")) cmdRegister(scanner, cal);
            else if (cmd.equals("2")) cmdSearch(scanner, cal);
            else if (cmd.equals("3")) cmdCal(scanner, cal);
            else if (cmd.equals("h")) printMenu();
            else if (cmd.equals("q")) break;
        }


        System.out.println("End.");
        scanner.close();
    }

    private void cmdRegister(Scanner s, DayOfWeek3 c) {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해주세요 : (yyyy-MM-dd)");
        String date = s.next();
        System.out.println("일정을 입력해주세요 (문장의 끝에 ;입력)");
        String text = "";
        while(true){
            String word = s.next();
            text+=word+" ";
            if (word.endsWith(";")){
                break;
            }
        }
        c.registerPlan(date, text);
    }

    private void cmdSearch(Scanner s, DayOfWeek3 c) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해주세요 : (yyyy-MM-dd)");
        String date = s.next();
        String plan = s.nextLine();
        try{
            plan = c.searchPlan(date);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("일정 검색 중 오류 발생");
        }
        System.out.println(plan);
    }

    private void cmdCal(Scanner s, DayOfWeek3 c) {
        int month = 1;
        int year = 2017;

        System.out.println("연도를 입력하시오.");
        System.out.print("Year> ");
        year = s.nextInt();

        System.out.println("달을 입력하시오.");
        System.out.print("Month> ");
        month = s.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        c.printCalendar(year, month);
    }


    public static void main(String[] args) {
        // 셀 실행
        prompt4 p = new prompt4();
        p.runPrompt();
    }

}


/**
 * 요구사항
 * - 간단한 콘솔 기반 사용자 UI 생성(일정 검색용)
 * - 오늘 잘짜를 인식해 새당 월의 달력 출력
 * - 달력에서 일정이 있는 날 아래에 . 을 찍어 출력
 * -  일정 등록, 검색, 변경 가능하게 한다.
 * - 오늘의 일정 표시.
 * <p>
 * 힌트 및 키워드 : ArrayList와 Hashmap 선행 학습
 * ArrayList :
 * - 크기를 조정할 수 있는 배열
 * - ArrayList[<String>] list = new ArraryList); 형태로 선언
 * - list.add(""); add()를 통해 추가 <> .remove()를 통해 삭제 // .get()을 사용해 값 출력
 * [참고]https://onlyfor-me-blog.tistory.com/249
 * Hashmap
 * - map 인터페이스에 속한 컬렉션으로 (key,value)의 1:1 구조로된 Entry
 * - Hashmap<Integer, Integer> i = new HashMap<>();
 * - Hashmap<타입, 타입> 변수명 = new HashMap<타입,타입>(); 형태로 선언
 * - .put(key,value) 통해 값 추가 <> .remove(); 를 통해 값 삭제
 * [참고] https://crazykim2.tistory.com/587
 */