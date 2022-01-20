# java modifier_2

- final 제어자

  - 필드, 지역 변수, 메서드, 클래스 앞에 위치할 수 있다.

  - 어디에 위치하느냐에 따라 의미가 다르다.

    -----

  - 필드

    - ```
      class A1 {
      	int a = 3;
      	final int b = 5;
      	A1(){
      	}
      }
      class A2 {
      	int a;
      	final int b;
      	A2(){
      		a = 3;
      		b = 5;ㄹ
      	}
      }
      class A3 {
      	int a = 3;
      	final int b = 5;
      	A3(){
      		a = 7;
      //		b = 9;				불가능
      	}
      }
      ```

    - 필드에서 사용 시, 한번 초기화 되면 변경할 수 없다.

  - 지역변수

    - ```
      class B {
      	void bcd(){
      		int a = 3;
      		final int b = 5;
      		a = 7;
      //		b = 9;				불가능
      	}
      }
      ```

    - 필드와 똑같이 한번 초기회되면 변경할 수 없다.

  - 동일한 값은 넣어서 초기화하더라도 오류가 발생한다.

  - 일반적인 필드와 지역 변수는 생성 시. 스택 메모리에 힙 메모리 주소값을 저장하고 힙 메모리에 값들을 저장하지만, final로 선언된 필드와 지역변수는 추가적으로 상수 영역에 고유값을 한번 더 추가적으로 저장한다.

  - 언제 사용할까?

    - 일상 생활에서 사무적인 자료들 같은 경우 원본은 그대로 놔두고 사본을 이용하여 자료로 활용을 한다.

      이와 같이 final로 원본을 만들고 다른 필드나 변수에 복사하여 사본으로서 활용을 한다.

    -----

  - final 메서드

    - ```
      class A {
      	void abc(){}
      	final void bcd(){}
      }
      class B extends A {
      	void abc(){}
      //	final void bcd(){}			불가능
      }
      ```

    - final로 선언된 메서드의 경우 위와 같이 오버라이딩이 불가능하다.

  - final 클래스

    - ```
      class A {}
      //class B extends A {}			불가능
      ```

    - final 클래스의 경우 상속 자체가 되지 않는다.



- abstract 제어자

  - abstract의 사전적인 의미 : 추상적인

    abstract 제어자는 말 그대로 "추상적인 제어자"라는 의미를 가지고 있다.

  - ```
    abstract class Animal {
    	abstract void cry();
    }
    class Cat extends Animal {
    	void cry() {
    		System.out.println("야옹");
    	}
    }
    class Dog extends Animal() {
    	void cry() {
    		System.out.println("멍멍");
    	}
    }
    
    public class decault_class {
    	public static void main(String[] args) {
    		Animal cat = new Cat();
    		Animal dog = new Dog();
    		
    		cat.cry();
    		dog.cry();
    	}
    }
    ```

    ```
    야옹
    멍멍
    ```

  - 사용하는 이유

    - ```
      class Cat extends Animal {
      	void cRy() {
      		System.out.printn("야옹")
      	}
      }
      ```

    - 다음과 같이 Cat클래스에서 메서드를 작성해도 오버라이딩은 그대로 발생한다.

    - 일반 클래스였다면 오타가 발생하여 오버라이딩이 제대로 일어나지 않았을 것이다.

    - abstract 클래스를 사용하는 이유는 다른 사람들과 협업 활동을 하는 과정에서 발생하는 문제들을 해결할 수 있기 때문에 사용한다.

