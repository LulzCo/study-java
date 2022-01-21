# inner class and inner interface

클래스 내부에는 필드, 메서드, 생성자와 더불어 이너 클래스, 이너 인터페이스까지 총 4가지 종류의 요소만 존재할 수 있다.

- inner class

  - member inner class

    - instance member inner class

      - ```
        class A {
        	class B {
        		...
        	}
        }
        ```

        A : outer class

        B : inner class

      - 객체 생성 방법

        - ```
          A a = new A();
          A.B b = new B();
          ```

      - 이너 클래스를 사용하기 위해서는 아우터 클래스를 먼저 객체로 생성을 해야한다.

      - 이너 클래스에서 아우터 클래스 멤버 호출하기

        - ```
          class A {
          	void abc() {}
          	...
          	class B {
          		void abc(){}
          		void bcd() {
          			abc();					//B 클래스의 abc
          			A.this.abc();		//A 클래스의 abc
          		}
          	}
          }
          ```

    - static member inner class

      - ```
        class A {
        	static class B {
        	}
        }
        ```

      - 인스턴스 멤버 이너 클래스와는 달리 객체를 바로 선언할 수 있다.

      - ```
        A.B b = new A.B();
        ```

  - local inner class

    - ```
      class A {
      	void abc() {
      		class B {
      		}
      		B b = new B();
      	}
      }
      ```

    - 활용

      - ```
        class A {
            int a = 3;
            void abc() {
                class B {
                    int b = 5;
                    void bcd() {
                        System.out.println(a);
                        System.out.println(b);
                        a=5;
        //                b=7;      지역 이너 클래스에서 변수 선언은 자동으로 final로 선언된다.
                    }
                }
                B bb = new B();
                bb.bcd();
            }
        }
        public class default_class{
            public static void main(String[] args){
                A a = new A();
                a.abc();
            }
        }
        ```

        ```
        3
        5
        ```

- annonymous inner class

  - 인스턴스 지역 익명 이너 클래스 : 클래스의 중괄호 바로 아래에 사용

  - 지역 익명 이너 클래스 : 메서드 내부에서 사용

  - 인스턴스 이너 클래스와 익명 이너 클래스 비교

    - 인스턴스 이너 클래스

      - ```
        class A {
        	C c = new B();
        	void abc() {
        		c.bcd();
        	}
        	class B implements C {
        		public void bcd() {
        			System.out.println("인스턴스 이너 클래스");
        		}
        	}
        }
        interface C {
        	public abstract void bcd();
        }
        
        public class default_class {
        	public static void main(Stringp[] args) {
        		A a = new A();
        		a.abc();
        	}
        }
        ```

    - 익명 이너 클래스

      - ```
        class A {
        	C c = new C() {
        		public void bcd() {
        			System.out.println("익명 이너 클래스");
        		}
        	};
        	void abc() {
        		c.bcd();
        	}
        }
        interface C {
        	public abstract void bcd();
        }
        
        public class default_class {
        	public static void main(String[] args) {
        		A a = new A();
        		a.abc();
        	}
        }
        ```

        

    