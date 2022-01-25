# exception handling_2

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

    - 

