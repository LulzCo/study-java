/**
 * 자료형
 */
public class Chapter3 {
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
    }
    public static void main(String[] args){
//        printNumbers();
//        printBooleans();
//        printChar();
        printString();
    }
}
