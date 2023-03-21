public class Chapter3 {

    public static void main(String[] args) {
        aboutString();
        aboutOperator();
        printNumbers();
        printBooleans();
        printChar();
        printString();
    }

    public static void aboutString() {
        String str1 = "abc";
        String str2 = new String("abc");

        /* 문자열을 비교할 때는 항상 반드시 equals()를 사용할 것 */
        System.out.println(str2 == str1);           // false
        System.out.println(str1.equals(str2));      // true
    }

    public static void aboutOperator() {
        System.out.println(logicOperator() || logicOperator());     // 앞에 것이 참이면 다음 실행은 스킵
        System.out.println(bitOperator() | bitOperator());          // 앞에 것 뒤에 것 상관없이 모두 확인
    }
    static boolean logicOperator() {
        System.out.println("logic");
        return true;
    }
    static boolean bitOperator() {
        System.out.println("bit");
        return true;
    }
    public static void printNumbers() {
        System.out.println("Chapter3");
        System.out.println("--------");

        // <정수>
        // int -> 최댓값 약 20억
        int a = 0;
        while (a >= 0) {
            a = a + 100000000;
            System.out.println(a);
        }

        // long -> 최댓값 약 900경ㅋㅋㅋㅋ..
        long b = 0;
        while (b >= 0) {
            b = b + 10000000000000L;
            System.out.println(b);
        }

        // <실수>
        // double -> 기본형
        double d = 3.14;
        System.out.println(d);

        // float
        float c = 3.14F;
        System.out.println(c);

        // <8진수와 16진수>
        // 8진수
        int octal = 023;        // 십진수 19
        System.out.println(octal);

        // 16진수
        int hex = 0xC;          // 십진수 12
        System.out.println(hex);
    }

    public static void printBooleans() {
        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println(isTrue);
        System.out.println(isFalse);
    }

    public static void printChar() {
        // 문자 츨력 - 쌍 따옴표가 아니라 따옴표로 사용해야 한다.
        char a = 'a';
        System.out.println(a);
    }

    public static void printString() {
        // 문자열 출력
        String a = "abcdefg";
        System.out.println(a);

        // 문자열 객체 출력
        String b = new String("abcdefg");
        System.out.println(b);

        //  String 클래스의 내장 함수
        // equals()
        System.out.println(a.equals(b));            // 같은 문자열인지
        System.out.println(a == b);                 // 같은 객체인지

        // indexOf()
        System.out.println(a.indexOf("abc"));       // 파라미터 문자열값이 어디부터 시작하는지 -> 존재하지 않는다면 -1

        // contains()
        System.out.println(a.contains("f"));
        System.out.println(a.contains("h"));

        // charAt()
        System.out.println(a.charAt(3));

        // replaceAll()
        System.out.println(a.replace('a', 'b'));
        System.out.println(a.replaceAll("bcd", "234"));

        // subString()
        System.out.println(a.substring(0, 2));

        // toUpperCase()
        System.out.println(a.toUpperCase());

        // split() -> 배열로 리턴
        String c = "a:b:c:d";
        System.out.println(c);
        String[] result = c.split(":");
        for (int i = 0; i < result.length; i++) {           // 자바의 배열을 출력시키면 메모리값이 나온다
            System.out.print(result[i]);
        }
        System.out.println();

        // formatting
        System.out.println(String.format("I want to buy %d %s!!", 3, "macbook"));

        // 정렬과 공백
        System.out.println(String.format("--%10s--", "hi"));        // 오른쪽 글자
        System.out.println(String.format("--%-10s--", "hi"));       // 왼쪽 글자
    }
}
