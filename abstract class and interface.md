# abstract class and interface

- 추상 메서드

  - ```
    abstract void method_name();
    ```

    - 다음과 같이 추상 메서드는 중괄호와 코드가 없기 때문에 미완성 메서드이다.
    - 추상 메서드는 반드시 추상 클래스 안에 속해야 한다.

- 추상 클래스

  - 추상 클래스는 미완성 메서드를 가지고 있기 때문에 객체를 생성할 수 없다.

  - 추상 클래스 안에 일반 메서드가 포함될 수 있다.

  - 그러나 추상 클래스는 미완성 클래스이기 때문에 객체를 생성할 수 없다.

    따라서 일반 메서드를 만들더라도 사용할 수 없기 때문에 매우 비효율적이다.

- 일반 클래스와 추상 클래스 비교하기

  - 일반 클래스는 부모 클래스와 자식 클래스 사이에 오버라이딩이 가능하다.
  - 추상 클래스는 부모 클래스와 자식 클래스 사이에 오버라이딩이 아니라 구현이라 표현한다.
    - 미완성 메서드를 완성시켜야 하기 때문

- 추상 클래스 객체화

  - ```
    abstract class A {}
    class B extends A {}
    
    public class default_class {
    	public static void main(String[] args) {
    		A a = new B();
    	}
    }
    ```

  - 추상 클래스를 객체화시키기 위해서는 반드시 자식 클래스를 통해 구현을 하고나서 사용해야만 한다.



-----

- 인터페이스

  - 인터페이스 내부의 모든 필드는 public static final로 정의

  - static, default 메서드 이외의 모든 메서드는 public abstract로 정의

  - interface 키워드 사용

  - 인터페이스 안에 모든 메서드는 추상 메서드이다.

    - 자바 8이 등장하며 해당 특징은 달라졌다.(default method도 포함 가능)

  - 인터페이스는 클래스를 상속받을 수 없다.

  - ```
    interface A {
    	public static final int a = 3;
    	public abstract void abc();
    }
    ```

    ```
    interface A {
    	int a = 3;
    	void abc();
    }
    ```

    위 두 코드는 같은 코드이다. 생략이 된 것일 뿐 없어진 것이 아니다.

- 인터페이스 상속

  - ```
    interface A {}
    intterfac B {}
    
    // 인터페이스의 인터페이스 상속
    interface A extends B{}
    
    // 클래스의 인터페이스 상속
    class C implements A {}
    
    // 클래스의 다중 인터페이스 상속
    class D implements A, B {}
    
    // 클래스와 인터페이스를 한 번에 상속
    class E extends C implements A, B {}
    ```

    다음과 같이 인터페이스를 상속할 수 있다.

  - 클래스와 인터페이스를 한 번에 상속할 경우

    - extends와 implements 의 순서는 바뀌어서는 안된다.

  - extends : 같은 타입을 상속할 때 사용

    implements : 다른 타입을 상속할 때 사용

  - ```
    interface A {
    	public abstract abc();
    	void bcd();					// public abstract 자동 추가
    }
    
    class B implements A {
    //	void abc(){}			오류 발생
    // 	void bcd(){}			오류 발생
    }
    ```

    public 은 default가 될 수 없기에 오류 발생

  - 인터페이스를 객체로 생성할 경우 두 가지 방법이 있다.

    1. 일반 클래스로 상속하여 객체 생성

    2. 익명 이너 클래스 사용

       ```
       interface A {
       	void abc();
       }
       
       public class default_class {
       	public static void main(String[] args){
       		A a = new A(){
       			public void abc() {
       				...
       			}
       		}
       	}
       }
       ```

    - 1번의 경우 다회성

      2번의 경우 일회성

- 디폴트 메서드와 정적 메서드

  - ```
    interface A {
        void abc();
        default void bcd() {
            System.out.println("A 인터페이스의 bcd()");
        }
    
        static void cde() {
            System.out.println("A 인터페이스의 cde()");
        }
    }
    
    class B implements A {
        public void abc() {
            System.out.println("B 클래스의 abc()");
        }
    }
    class C implements A {
        public void abc() {
            System.out.println("C 클래스의 abc()");
        }
        public void bcd() {
            A.super.bcd();
            System.out.println("C 클래스츼 bcd()");
        }
    }
    
    public class default_class{
        public static void main(String[] args){
            A a1 = new B();
            A a2 = new C();
    
            a1.abc();
            a1.bcd();
            a2.abc();
            a2.bcd();
            A.cde();
        }
    }
    ```

    ```
    B 클래스의 abc()
    A 인터페이스의 bcd()
    C 클래스의 abc()
    A 인터페이스의 bcd()
    C 클래스츼 bcd()
    A 인터페이스의 cde()
    ```
  
    - C 객체를 생성하여 실행하였을 때,
      - abc() : 구현
      - bcd() : 오버라이딩
    - C 클래스에서 메서드를 생성할 때, 부모의 메서드를 호출하고 싶은 경우
      - interface_name.super.method_name 형식으로 호출을 하면 된다.
    - A 인터페이스에서 정적 메서드를 생성하여 사용할 수 있다.ㅎ
