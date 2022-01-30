# dexception handling_2

- 예외를 처리하는 방법

  - try-catch 구문
  - 예외 전가

- 예외 전가

  - 예외가 발생한 지점에서 자신을 호출한 메서드에게 예외 처리의 의무를 넘긴다.

    그 메서드에서도 자신을 호출한 상위 메서드에게 전가할 수 있다.

  - 메서드를 만들 때, 예외를 전가시킬 클래스를 추가

    - ```
      return_type methond_name(parameters) throws exception_class {
      	//예외 발생 코드 ...
      }
      ```

      throws 키워드로 예외를 전가시킬 클래스를 정한다.

  - ex)

    - 하위 메서드에서 직접 예외 처리

      - ```
        class A {
            void abc() {
                bcd();
            }
            void bcd() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread.sleep 오류 발생");
                }
            }
        }
        ```

    - 상위 메서드로 예외 전가

      - ```
        class B {
            void abc() {
                try {
                    bcd();
                } catch (InterruptedException e) {
                    System.out.println("bcd() 메서드 오류 발생");
                }
            }
            void bcd() throws InterruptedException {
                Thread.sleep(1000);
            }
        }
        ```

- 다중 예외 전가

  - ```
    // 1. 하위 메서드에서 직접 예외 처리
    class A {
        void abc() {
            bcd();
        }
        void bcd() {
            try {
                Thread.sleep(1000);
                Class cls = Class.forName("java.lang.Object");
            } catch (InterruptedException | ClassNotFoundException e) {
                System.out.println("예외 발생");
            }
        }
    }
    
    // 2. 상위 메서드로 예외 전가
    class B {
        void abc() {
            try {
                bcd();
            } catch (InterruptedException | ClassNotFoundException e) {
                System.out.println("예외 발생");
            }
        }
        void bcd() throws InterruptedException, ClassNotFoundException {
            Thread.sleep(1000);
            Class cls = Class.forName("java.lang.Object");
        }
    }
    ```

-----

- 사용자 정의 예외 클래스

  - ex) int age = -1; 코드는 예외가 발생하지 않는 코드이다.

    그러나, 사람의 나이임을 명시한다면 예외를 발생시켜야 한다.

    이 때, 사용자 정의 예외 클래스를 필요로 하는 것이다.

  - 예외 클래스 생성 순서

    - throw : 예외 발생시키기

    - throws : 예외 전가시키기

    - 일반 예외

      - ```
        // 1. 사용자 정의 예외 클래스 작성
        class MyException extends Exception {
        	MyException() {}
        	MyException(String s) {
        		super(s);
        	}
        }
        
        // 2. 사용자 정의 예외 객체 생성
        MyException me1 = new MyException();
        MyException me2 = new MyException("예외 메시지")
        
        // 3. 예외 상황에서 객체 던지기
        throw me1;
        throw me2;
        throw new MyException();
        throw new MyException("예외 메시지");
        ```

    - 실행 예외

      - ```
        // 1. 사용자 정의 예외 클래스 작성
        class MyRTException extends RuntimeException {
        	MyRTException() {}
        	MyRTException(String s) {
        		super(s);
        	}
        }
        
        // 2. 사용자 정의 예외 객체 생성
        MyRTException mre1 = new MyRTException();
        MyRTException mre2 = new MyRTException("예외 메시지")
        
        // 3. 예외 상황에서 객체 던지기
        throw mre1;
        throw mre2;
        throw new MyRTException();
        theow new MyRTException("예외 메시지");
        ```

  - 예외를 처리하는 방법

    1. 예외를 해당 메서드 안에서 직접 처리

       ```
       void abc(int age) {
       	try {
       		if (age >= 0) {
       			System.out.println("정상값");
       		} else {
       			throw new MyException();
       		}
       	} catch (My Exception e){
       		System.out.println("예외 처리");
       	}
       }
       void bcd() {
       	abc(-2);
       }
       ```

    2. 예외를 상위 메서드로 전가해 예외 처리

       ```
       void abc(int age) throws MyException {
       	if (age >= 0) {
       		System.out.println("정상값");
       	} else {
       		throw new MyException();
       	}
       }
       void bcd() {
       	try {
       		abc(-2);
       	} catch (MyException e) {
       		System.out.println("예외 처리");
       	}
       }
       ```

- 예외 클래스의 메서드

  - getMessage() 메서드

    - 예외가 발생했을 때 생성자로 넘긴 메시지를 문자열 형태로 리턴하는 메서드

    - 예외 객체를 생성했을 때 메시지를 전달하지 않았을 경우

      ```
      try {
      	throw new Exception();
      } catch (Exception e) {
      	System.out.println(e.getMessage());			// null return
      }
      ```

    - 예외 객체를 생성했을 때 메시지를 전달했을 경우

      ```
      try {
      	throw new Exception("예외 메시지");
      } catch {
      	System.out.println(e.getMessage());			// 예외 메시지 return
      }
      ```

  - printStackTrace() 메서드

    - 예외 발생이 전달되는 경로, 즉 예외가 전가된 과정을 한눈에 확인할 수 있는 메서드

    - ```
      class A {
          void abc() throws NumberFormatException {
              bcd();
          }
          void bcd() throws NumberFormatException {
              cde();
          }
          void cde() throws NumberFormatException {
              int num = Integer.parseInt("10A");
          }
      }
      
      public class default_class {
          public static void main(String[] args) {
              A a = new A();
              try {
                  a.abc();
              } catch (NumberFormatException e) {
                  e.printStackTrace();
              }
          }
      }
      ```

      ```
      java.lang.NumberFormatException: For input string: "10A"
      	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
      	at java.base/java.lang.Integer.parseInt(Integer.java:668)
      	at java.base/java.lang.Integer.parseInt(Integer.java:786)
      	at A.cde(default_class.java:11)
      	at A.bcd(default_class.java:8)
      	at A.abc(default_class.java:5)g
      	at default_class.main(default_class.java:19)
      
      Process finished with exit code 0
      ```

      예외 발생이 전달되는 경로가 parseInt -> cde -> bcd -> abc -> main 임을 알 수 있다.

