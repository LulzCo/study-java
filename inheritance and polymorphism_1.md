# inheritance and polymorphism_1

- 상속

  - ```
    class 부모 클래스{}
    class 자식 클래스{} extends 부모 클래스
    ```

  - 여러 부모 클래스 상속은 불가능 하다.

    - ```
      class 부모 클래스1{}
      class 부모 클래스2{}
      class 자식 클래스{} extends 부모 클래스1, 부모 클래스2			// 불가능
      ```

      불가능

  - 코드 중복을 방지한다.

  - ```
    class Human{
        String name;
        int age;
        void eat(){}
        void sleep(){}
    }
    
    class Student extends Human{
        int studentID;
        void goToSchool(){}
    }
    
    class Worker extends Human{
        int workerID;
        void goToWork(){}
    }
    public class default_class{
        public static void main(String[] args){
            Human a = new Human();
            a.name = "aaa";
            a.age = 24;
            a.eat();
            a.sleep();
            
            Student b = new Student();
            b.name = "bbb";
            b.age = 20;
            b.studentID = 11111;
            b.eat();
            b.goToSchool();
            b.sleep();
            
            Worker c = new Worker();
            c.name = "ccc";
            c.age = 42;
            c.workerID = 22222;
            c.eat();
            c.goToWork();
            c.sleep();
        }
    }
    ```

  - 메모리 구조

    - 클래스 영역
      - 클래스 저장
    - 스택 영역
      - 객체의 주소 저장
    - 힙 영역
      - 객체(객체의 값들) 저장

  - 생성자는 상속되지 않는다.

    - A 클래스 : 부모클래스

      B 클래스 : 자식클래스

      A의 생성자가 상속이 되면 B의 생성자와 충돌이 일어나 오류가 발생하기 때문에 생성자를 생성하지 않는다.

  - 다형적 표현

    - ```
      class A{}
      class B extends A{}
      
      A a = new A();
      A b = new B();
      ```

- 객체의 타입 변환

  - 업캐스팅과 다운캐스팅

    ```
    class A{}
    class B extends A{}
    class C extends B{}
    ```

    - 업캐스팅

      ```
      B b1 = new B();
      A a1 = b1;			//컴파일러가 자동으로 A를 추가 => A a1 = A b1;
      								//즉, B에서 A로 업캐스팅
      
      C c2 = new C();
      B b2 = c2;			//C -> B
      A a2= c2;				//C -> A
      ```

    - 다운캐스팅

      ```
      A a1 = new A();
      b b1 = a1;			//예외 발생
      
      A a2 = new B();
      B b2 = a2;			//가능
      C c2 = a2;			//예외 발생
      ```

      - 문법적 오류는 존재하지 않지만 실제 캐스팅하는 과정에서 예외가 발생하여 불가능하다.
      - 하지만 애초에 자식클래스 생성자로 선언하였다면 가능하기도 하다.

- 캐스팅 가능 여부를 확인하는 instanceof 키워드

  - A -> B -> C 상속구조

    ```
    C c = new C();
    System.out.println(c instanceof A);
    System.out.println(c instanceof B);
    System.out.println(c instanceof C);
    ```

    ```
    true
    true
    true
    ```

- 객체의 타입 변환

  - 업캐스팅(자동변환)과 다운캐스팅(수동변환)

    - 업캐스팅은 괄호() 생략 가능, 다운캐스팅은 괄호() 생략이 필수적이다.
  
  - ```
    class A{}
    class B extends A{}
    ```

    ```
    //첫 번째 이미지
    B bb = new B();             //업캐스팅
    A a = (A) bb;
    
    A aa = new A();             
    //        B b = (B) aa;			//다운캐스팅 오류
    ```
  
    ```
    //두 번째 이미지
    A ab = new B();							//다운캐스팅
    B b = (B) ab;			
    ```
  
    <img src="/Users/seongwon/workspace/study/Java/Java_study/inheritance and polymorphism_1-1.png" alt="inheritance and polymorphism_1-1" style="zoom:50%;" />

- 메서드 오버라이딩

  - ```
    class A{
        void print(){
            System.out.println("A클래스");
        }
        void arint(){
            System.out.println("A클래스 aprint");
        }
    }
    class B extends A{
        void print(){
            System.out.println("B클래스");
        }
        void brint(){
            System.out.println("B클래스의 bprint");
        }
    }
    
    public class default_class{
        public static void main(String[] args){
            A aa = new A();
            aa.print();
    
            B bb = new B();
            bb.print();
    
            A ab = new B();
            ab.print();
            ab.arint();
    //        ab.brint();			//오류 발생
        }
    }
    ```

    ```
    A클래스
    B클래스
    B클래스
    A클래스 aprint
    ```

  - 덮어쓰기의 개념과 비슷하다.

    - 비슷한 것이지 같은 것은 아니다.
    - 덮어쓰기
      - 이전 파일을 아예 삭제하고 새로 쓰는 것

  - 오버라이딩

    - 이전 메서드를 잠시 숨겨두고 그 위에 새로운 메서드로 위장하는 것이다.
    - 언제든 안에 있는 메서드를 사용할 수 있다.
    
  - 오버라이딩과 접근지정자
  
    - 접근지정자 범위
    
      - public > protected > default > private
    
    - 부모 클래스 메서드의 접근 지정자에 따른
    
      자식 클래스 메서드의 가능한 접근지정자
    
      | 부모클래스의 접근 지정자 | 자식클래스의 접근 지정자            |
      | :----------------------: | :---------------------------------- |
      |          public          | public                              |
      |        protected         | public, protected                   |
      |         default          | public, protected, default          |
      |         private          | public, protected, default, private |
    
      - 오버라이딩을 할 경우 자식클래스의 접근지정자는 부모클래스보다 넓어야 사용가능하다.