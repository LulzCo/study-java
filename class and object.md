# class and object

- 자바에서의 객체지향 문법

  - 클래스

    - 일반 클래스

      - ```
        class A{
        	...
        	void abc(){
        		...
        	}
        }
        ```

    - 추상 클래스

      - ```
        abstract class A{
        	...
        	abstract void abc(){
        		...
        	}
        }
        ```

  - 인터페이스

    - ```
      interface A{
      	public static final int n = 1;
      	...
      	public static void abc(){
      		...
      	}
      }
      ```

- .java 파일 내에서 public 은 최대 1개의 class만을 가질 수 있다.

​		.public이 붙은 클래스명이 파일명과 동일해야 한다.

- 클래스와 객체의 차이

  - 클래스는 객체를 만드는 생성자이다.

    이를, "인스턴스화"라고 한다.

  - 객체는 클래스의 인스턴스화로 인해 만들어진 객체이다.

    이 객체를 "인스턴스"라고 하기도 한다.

- 클래스의 메모리 구조

  - String의 메모리 구조와 같다.

- 클래스 구성과 객체의 생성 및 활용

  - ```
    class A{
        int n = 3;
        void print(){
            System.out.println("객체 생성");
        }
    }
    public class class_test {
        public static void main(String[] args) {
            A a = new A();
            System.out.println(a.n);
            a.n = 5;
            System.out.println(a.n);
    
            a.print();
        }
    }
    ```

    ```
    3
    5
    객체 생성
    ```

    