# Operator

- 연산자 사용 방법

  - ```
    public class test_class {
    	public static void main(String[] args) {
    		int a;
    		int b;
    		
    		a = 3;
    		b = 5;
    		
    		int sum = a + b;
    		
    		System.out.println(sum);		// 8
    		System.out.println(++sum);		// 9
    ```

- 비교연산자

  - ```
    public class test_class{
    	String a = new String("안녕");
    	String b = new String("안녕");
    	
    	if(a == b){
    		System.out.println("일치");
    	}else{
    		System.out.println("불일치");
    	}
    }
    ```

    ```
    불일치
    ```

  - 기본자료형과 참조자료형의 차이

    - <u>자바에서 비교연산자는 스택메모리 값을 비교한다.</u> 

      지금 a와 b의 스택 메모리에는 "안녕"이라는 값이 저장되어 있는 힙 메모리의 주소값이 들어가 있기 때문에 불일치가 나온다.

- 삼항연산

  - ```
    public class class_test {
        public static void main(String[] args){
            int a;
            int b;
            
            a = 3;
            b = (a>5) ? 10:20;
            
            System.out.println(b);		//20
        }
    }
    ```

  - 