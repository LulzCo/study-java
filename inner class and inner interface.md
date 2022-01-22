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

  - 익명 이너 클래스를 사용하는 경우 항상 부모 타입으로만 선언할 수 있다.

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
        
        ```
        interface C {
        	public abstract void bcd();
        }
        
        class B implements C {
        	public void bcd() {}			// 오버라이딩 메서드
        	public void cde() {}			// 추가 메서드
        }
        
        B b = new B();
        b.bcd();			// enable
        b.cde();			// enable
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
  
        ```
        interface C {
        	public abstract void bcd();
        }
        
        C c = new C() {
        	public void bcd() {			// 오버라이딩 메서드
        		cde();								// 내부적으로 호출 가능
        	}
        	public void cde() {}		// 추가 메서드
        }
        
        c.bcd();			// enable
        c.cde();			// disable
        ```
  
  - 익명 이너 클래스 활용
  
    - ```
      interface A {
      	public abstract void abc();
      }
      
      class C {
      	void cde(A a) {
      		a.abc();
      	}
      }
      
      class B implements A {
      	public void abc() {
      		...
      	}
      }
      ```
  
      다음 코드에서 abc() 메서드를 사용하기 위해서는 4가지 방법이 있다.
  
      1. ```
         C c = new C();
         
         A a1 = new B();
         c.cde(a1)
         ```
  
      2. ```
         C c = new C();
         
         c.cde(new B());
         ```
  
      3. ```
         C c = new C();
         
         A a = new A() {
         	public void abc() {
         		...
         	}
         };
         c.cde(a);
         ```
  
      4. ```
         C c = new C();
         
         c.cde(new A() {
         	public void abc() {
         		...
         	}
         });
         ```
  
      - 1번과 2번은 자식 클래스를 직접 정의
      - 3번과 4번은 익명 이너 클래스를 사용
  
    - 이와 같이 클래스를 매개 변수로 하여 사용하는 경우에 익명 이너 클래스를 사용하는 것이 코드가 더 간결해진다.
  
      익명 이너 클래스를 사용하는 경우 따로 자식 클래스를 선언하지 않아도 되기 때문이다.

-----

- inner interface