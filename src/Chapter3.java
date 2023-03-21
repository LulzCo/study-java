public class Chapter3 {

    public static void main(String[] args) {
//        aboutString();
        aboutOperator();

    }

    public static void aboutString() {
        String str1 = "abc";
        String str2 = new String("abc");

        /* 문자열을 비교할 때는 항상 반드시 equals()를 사용할 것 */
        System.out.println(str1 == str2);           // false
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

}
