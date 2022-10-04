// 두 수의 합구하기
import java.util.Scanner;

public class sum {
    public static void main(String[] args){
        // 입력 : 키보드로 두 수를 입력 받음.
        // 출력 : 화면에 두 수의 합 출력.
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하시오");
        String inputValues = sc.nextLine();

        String[] splitValues = inputValues.split(" ");

        int first = Integer.parseInt(splitValues[0]);
        int second = Integer.parseInt(splitValues[1]);

        System.out.println("두 수의 합은 "+(first+second)+"이다.");

    }
//    //방법2
//    public static void main(String[] args){
//        int a,b;
//        Scanner scanner = new Scanner(system.in);
//        String s1,s2;
//        System.out.println("두 수를 입력해주시오 : ");
//        s1=scanner.next();
//        s2=scanner.next();
//        System.out.println(s1 + ", " + s1);
//
//        a = integer.parseInt(s1);
//        b = integer.parseInt(s2);
//
//        int c = a+b;
////        System.out.println("두 수의 합은 "+c+"입니다.");
//        System.out.printf("두 수의 합은 %d 입니다.",c);
//        scanner.close();
//    }
}

