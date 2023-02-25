# inheritance and polymorphism_2

- 인스턴스 필드와 정적 멤버의 중복

  - 인스턴스 필드의 중복

    - ```
      class A{
          int m = 3;
      }
      
      class B extends A{
          int m = 4;
      }
      public class default_class{
          public static void main(String[] args){
              A aa = new A();
              B bb = new B();
              A ab = new B();
      
              System.out.println(aa.m);
              System.out.println(bb.m);
              System.out.println(ab.m);
          }
      }
      ```

      ```
      3
      4
      3
      ```

    - 클래스 B가 만들어질 때, 부모클래스인 A가 만들어진 후에 B가 만들어진다.

    - 이때, A의 m과 B의 m은 서로 다른 저장 공간에 저장이 되어 오버라이딩이라 할 수 없다. 

    - B 타입으로 만들어진 객체는 B를 더 우선시 하기에 B의 m값인 4를 출력한다.

  - 정적 필드의 중복

    - ```
      class A{
          static int m = 3;
      }
      
      class B extends A{
          static int m =4;
      }
      public class default_class{
          public static void main(String[] args){
              System.out.println(A.m);
              System.out.println(B.m);
              System.out.println();
              
              A aa = new A();
              B bb = new B();
              A ab = new B();
      
              System.out.println(aa.m);
              System.out.println(bb.m);
              System.out.println(ab.m);
          }
      }
      ```

      ```
      3
      4
      
      3
      4
      3
      ```

    - 인스턴스 필드의 중복 특징과 똑같다.

  - 정적메서드의 중복

    - 인스턴스 메서드의 중복의 경우 오버라이드가 발생

    - 정적 메서드의 경우, 정적 필드의 중복과 같이 서로 다른 공간에 저장이 되어 정적 필드의 중복 특징과 같다.

    - ```
      class A{
          static void print(){
              System.out.println("A클래스");
          }
      }
      
      class B extends A{
          static void print(){
              System.out.println("B클래스");
          }
      }
      public class default_class{
          public static void main(String[] args){
              A.print();
              B.print();
      				System.out.println();
      				
              A aa = new A();
              B bb = new B();
              A ab = new B();
      
              aa.print();
              bb.print();
              ab.print();
          }
      }
      ```

      ```
      A클래스
      B클래스
      
      A클래스
      B클래스
      A클래스
      ```

- super 키워드와 super() 메서드

  - super 키워드

    - ```
      class A{
          void abc(){
              System.out.println("A클래스의 abc메서드");
          }
      }
      
      class B extends A{
          void abc(){
              System.out.println("B클래스의 abc메서드");
          }
          void bcd(){
              abc();
          }
          void cde(){
              super.abc();
          }
      }
      
      public class default_class{
          public static void main(String[] args){
              B bb = new B();
      
              bb.bcd();
              bb.cde();
          }
      }
      ```

      ```
      B클래스의 abc메서드
      A클래스의 abc메서드
      ```

      - 오버라이딩이 발생하여  B클래스의 abc메서드가 호출된다.
      - super를 사용하면 오버라이딩 된 것이 아닌 부모 클래스의 함수를 호출할 수 있다.

  - super() 메서드

    - 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출하는 메서드이다.

    - super() 메서드는 생성을 하지 않아도 자동으로 추가가 된다.

      - ```
        class A{
            A(){
                this(3);
                System.out.println("A클래스 생성자 1");
            }
            A(int a){
                System.out.println("A클래스 생성자 2");
            }
        }
        
        class B extends A{
            B(){
        //    		super();		 있든 없든 출력 결과는 똑같다.
                this(3);
                System.out.println("B클래스 생성자 1");
            }
            B(int b){
        //    		super();		 있든 없든 출력 결과는 똑같다.
                System.out.println("B클래스 생성자 2");
            }
        }
        
        public class default_class{
            public static void main(String[] args){
                A aa1 = new A();
                System.out.println();
                A aa2 = new A(3);
                System.out.println();
        
                B bb1 = new B();
                System.out.println();
                B bb2 = new B(3);
            }
        }
        ```

        ```
        A클래스 생성자 2
        A클래스 생성자 1
        
        A클래스 생성자 2
        
        A클래스 생성자 2
        A클래스 생성자 1
        B클래스 생성자 2
        B클래스 생성자 1
        
        A클래스 생성자 2
        A클래스 생성자 1
        B클래스 생성자 2
        ```

- 최상위 클래스 Object

  - 자바에서 생성하는 모든 클래스는 Object 클래스의 자식 클래스이다.

  - "extends"가 쓰이지 않는 모든 클래스는 코드에서는 볼 수 없지만 "extends Object"가 추가되어 있다.

  - ```
    public class default_class{
        public static void main(String[] args){
            Object oo = new Object();
            System.out.println(oo);
        }
    }
    ```

  - Object 클래스 안에는 여러 메서드가 있다.

    - 대표적인 메서드
      - toString : 객체의 정보 리턴
      - equeals : 스택메모리 주소값 비교
      - hashCode : 객체의 HashCode 값 리턴
      - wait : 쓰레드 일시정지
      - notify, notifyAll :  일시정지 상태의 쓰레드를 다시 재생