# member of class

- 필드(field)

  - 클래스에 속하되 함수에는 속하지 않는 변수

  - ```
    class A(){
    	int i = 10;
    	...
    	void abc(int j){
    		int j = 10000;
    		...
    	}
    }
    ```

    int i => field

    int j => 지역 변수

    - 필드와 지역 변수는 구분된다.

  - ```
    class A{
        int m = 3;		//필드
        int n = 4;		//필드
        
        void work1(){
            int k = 5;		//지역변수
            System.out.println(k);
            work2(3);
        }
        
        void work2(int i){
            int j = 4;		//지역변수
            System.out.println(i+j);
        }
    }
    
    public class class_test{
        public static void main(String[] args){
            A a = new A();
            System.out.println(a.m);
            System.out.println(a.n);
            
            a.work1();
        }
    }
    ```

    ```
    3
    4
    5
    7
    ```

  - 필드는 초기화하지 않아도 강제 초기화가 된다.

    지역변수는 강제 초기화가 되지 않아 초기화를 하지 않으면 오류가 발생한다.

    *초기화 : 변수선언

- 함수(method)

  - public static void main()

    - public static : 자바 제어자
    - void : 함수 리턴 자료형
      - void, int, double, ...
    - main : 함수명

  - 함수 호출

    - ```
      class A(){
      	void abcPrint(){
      		System.out.println("abc");
      		return;
      	}
      }
      publuc class class_test(){
      	publuc static void main(String[] args){
      		A a = new A();
      		a.abcPrint();
      	}
      }
      ```

      1. A라는 클래스를 a라는 객체로 생성
      2. a라는 객체 안에서 abcPrint() 함수 호출

      - void의 경우 return 값이 없는 자료형이기 때문에 return만 사용
      - int, double과 같은 경우, return 값이 자료형에 맞게 리턴되어야 한다.

  - 자료형에 따른 매개변수 전달

    - 기본 자료형 입력매개변수의 전달
    - 참조 자료형 입력매개변수의 전달

    