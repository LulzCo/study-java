

# java modifier

- 접근 지정자

  - 멤버 및 생성자의 접근 지정자

    - public, protected, default(package), private

    - ```
      class Test{
          public int a;
          protected int b;
          int c;              //default 접근 지정자 자동 설정
          private int d;
          public void abc(){}
          protected void bcd(){}
          void cde(){}        //default 접근 지정자 자동 설정
          private void def(){}
      }
      ```

    - 접근 범위

      - public > protected > default > private

      - private : 자신의 클래스 내부에서만 사용할 수 있는 접근 지정자

      - default : 같은 패키지 안의 모든 클래스에서 사용할 수 있는 접근 지정자

        ​				'package 접근 지정자' 라고도 한다.

      - protected : 같은 패키지의 모든 클래스에서 사용할 수 있는 접근 지정자

      - public : 같은 패키지를 포함한 다른 패키지의 클래스에서도 사용할 수 있는 접근 지정자

  - 클래스의 접근 지정자

    - public, default

    - ```
      public class Test1{}
      class Test2{}				//default 접근 지정자 자동 설정
      ```

    - 접근 범위

      - public > default
      - 의미는 위 내용과 같다.

  - 연관성

    - test_package/A.java

      ```
      public class A{
      	public void abc(){}
      	void bcd(){}
      }
      class B{
      	public void abc(){}
      	void bcd(){}
      }
      ```

      다른 패키지에서 사용할 수 있는 지의 여부

      test_package.A					가능

      test_package.A.abc			 가능

      test_package.A.bcd			 불가능

      test_package.B					 불가능

      test_package.B.abc			 불가능

      test_package.B.bcd			 불가능

- static modifier(지정자)

  - 인스턴스와 정적

    - ```
      class Test{
          int m = 3;          //인스턴스 필드
          static int n = 5;   //정적 필드
          void abc(){
              System.out.println("인스턴스");
          }
          static void bcd(){
              System.out.println("정적");
          }
      }
      public class default_class {
          public static void main(String[] args){
              Test test = new Test();
              System.out.println(test.m);
              System.out.println(test.n);
              System.out.println(Test.n);
              test.abc();
              test.bcd();
              Test.bcd();
          }
      }
      ```

      ```
      3
      5
      5
      인스턴스
      정적
      정적
      ```

      - 인스턴스는 객체 생성이 필수적이다.

      - 정적은 객체 생성이 필수적이지 않다. -> 클래스명을 바로 사용하여 멤버를 바로 사용할 수 있다.

      - 정적 필드는 객체 간 공유 변수의 성질이 있다.

        - ```
          class Test{
          	int m = 1;
          	static int n = 2;
          }
          public class default_class{
          	public static void main(String[] args){
          		Test test1 = new Test();
          		Test test2 = new Test();
          		
          		test1.m = 3;
          		test2.m = 4;
          		System.out.println(test1.m);
          		System.out.println(test2.m);
          		
          		test1.n = 10;
          		test2.n = 20;
          		System.out.println(test1.n);
          		System.out.println(test2.n);	
          	}
          }
          ```

          ```
          3
          4
          20
          20
          ```

      - 정적 메서드는 권장하지 않는다.

      - 정적 메서드 내부에서는 정적 멤버만 사용할 수 있다.