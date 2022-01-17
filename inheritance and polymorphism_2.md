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