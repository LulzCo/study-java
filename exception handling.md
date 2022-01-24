# exception handling

- 예외와 오류의 차이
  - 예외 : 개발가가 처리할 수 있는 오루
  - 오류 : 개발자도 해결할 수 없는 오류

- 자바 클래스

  ```
  class Object {}
  class Throwable extends Object {}
  class Error extends Throwable {}
  class Exception extends Throwable {}
  class Checked_Exception extends Exception {}
  class Unchecked_Exception extends Exception {}
  ```

  - 예외 클래스의 상속 구조

    - 일반 예외(checked exception) : 컴파일 전에 체크

      - 컴파일 전에 예외처리를 하지 않으면 문법 오류가 발생

    - 실행 예외(unchecked exception or runtime exception) : 실행할 때 체크

      - 예외처리를 하지 않더라도 실행 가능

        다만, 프로그램 실행 시, 강제 종료 발생

- 일반 예외

  - 컴파일 전에 예외를 확인하기에 반드시 예외 처리가 필요하다.

  -  interruptedException

    - Thread.sleep(시간)
      - 메서드는 일정 시간 동안 해당 쓰레드를 일시정지 상태로 만드는 정적 메서드
      - Threade 실행 시  interruptedException 예외 발생 가능

  - ClassNotFoundException

    - Class.forName("패키지명.클래스명")
      - 클래스를 동적으로 메모리에 로딩하는 메서드
      - 해당 클래스의 정보를 담고 있는 Class 타입의 객체를 리턴
      - 만약 로딩하는 과정에서 해당 클래스가 존재하지 않을 경우 ClassNotFoundException 예외  발생

  - IOException

    - 자바 입출력 부분에서 콘솔이나 파일에 데이터를  쓰거나 읽을 때 IOException 예외 발생

  - FileNotFoundException

    - 파일을 읽을 때 해당 경로에 파일이 없으면 FileNotFoundException 예외 발생

  - CloneNotSupportedException

    - 자바의 모든 클래스는 Object 클래스 상속

      즉, Object의 모든 메서드 사용가능

      clone() 메서드는 자식의 객체를 복사한 클론 객체를 생성해 리턴하는 메서드

      그러나 복사를 하기 위해서는 cloneable 인터페이스를 상속해야만 한다.

      이 인터페이스를 상속하지 않은 채 복사를 하면 CloneNotSupportedException 예외 발생

- 실행 예외

  - ArithmeticException

    - 산술 또는 연산이 불가능할 때 발생하는 실행 예외
    - ex) 3을 0으로 나눌 때

  - ClassCastException

    - 업 캐스팅은 항상 가능하지만, 다운캐스팅은 항상 가능하지만은 않다.

      불가능할 때, 발생하는 실행 예외

  - ArrayIndexOutOfBoundException

    - 배열의 인덱스를 잘못 사용했을 때 빨생하는 실행 예외
    - ex) 배열의 크기는 3이지만 10번 째 인덱스를 출력시킬 때

  - NumberFormatException

    - 문자열을 정숫값으로 변환하고자 할 때, Integer.parseInt("문자열")

      ​			   실숫값으로 변환하고자 할 때, Double.parseDouble("문자열")

      이 때, 변환이 실패할 경우 실행 예외

  - NullPointerException 

    - 참조 변수가 실제 객체를 가리키고 있지 않은 상황에서 필드나 메서드를 호출할 때 실행 예외

    - ex)

      ```
      String a = null;
      a.abc();
      ```

-----

- 예외 처리 문법

  - ```
    try {
    	// 예외가 발생가능한 코드
    } catch {
    	// 예외가 발생했을 때 처리
    } finally {
    	// 예외 발생 여부에 상관없이 무조건 실행
    }
    ```

  - ex)

    ```
    try {
    	System.out.println(3/0)
    } catch (ArithmeticException e) {
    	System.out.println("0으로 나눌 수 없습니다.");
    } finally {
    	System.out.println("프로그램 종료");
    }
    ```

- 예외 처리 과정

  1. 예외 발생
  2. JVM에서 발생한 예외 클래스 객체 생성
  3. 객체를 catch로 전달

- 다중 예외 처리

  - catch 구문은 다중으로 사용이 가능

  - ```
    try {
    	...
    } catch () {
    	...
    } catch () {
    	...
    }
    ```

  - try에서 발생할 수 있는 예외 종류가 두 가지 이상일 경우 사용한다.

    그러나, catch 구문은 반드시 하나만 실행이 된다.

    if-else if-else 처럼 예외가 발생한 시점에서 바로 하나의 catch 구문만 실행이 된다.

  - catch 구문에서 주의해야할 점

    1. 잘못된 catch 순서

       ```
       try {
       	System.out.println(3 /1 );
       	int num = Integer.parseInt("10A");
       } catch (Exception e) {
       	System.out.println("숫자는 0으로 나눌 수 없습니다.");
       } catch (NumberFormatException e) {
       	System.out.println("숫자로 바꿀 수 없습니다.");
       }
       ```

       이 코드에서는 자료형 변환에서 오류가 발생했다. 그러기에 NumberFormatException catch 구문이 발생하는 것이 맞을 것이다.

       그러나!! 첫 번째 Exception catch 구문에서 Exception을 주의해야 한다.

       모든 예외는  Exception 클래스를 상속한다. 그래서 이 코드에서든 Exception catch 구문이 실행이 될 것이다.

    2. 올바를 catch 순서

       ```
       try {
       	System.out.println(3 /1 );
       	int num = Integer.parseInt("10A");
       } catch (NumberFormatException e) {
       	System.out.println("숫자로 바꿀 수 없습니다.");
       } catch (Exception e) {
       	System.out.println("숫자는 0으로 나눌 수 없습니다.");
       }
       ```

  - or 연산으로 한 줄로 만들기

    - catch 구문이 똑같을 경우 사용한다.

    1. 2개의  catch

       ```
       try {
       	...
       } catch (AException) {
       	...
       } catch (BException) {
       	...
       }
       ```

    2. 하나의 catch

       ```
       try {
       	...
       } catch (AException | BException) {
       	...
       }
       ```

- finally 활용

  - finally는 예외 발생과 상관없이 실행되는 구문
  - 보통 리소스를 해체시킬 때 사용
  - 메모리 효율을 올리기 위해서 리소스를 열었을 경우 닫는 것이 좋기에 사용

  1. 수동 해제

     ```
     inputStreamReader is = null;
     try {
     	is = new inputStreamReader(System.in);
     	system.out.println(is.read());
     } catch (IOException e) {
     	...
     } finally {
     	if (is != null) {
     		try {
     			is.close();
     		} catch (IOException e) {
     			...
     		}
     	}
     }
     ```

  2. 자동 해제

     ```
     try (inputStreamReader is = new inputStreamReader();) {
     	System.out.println(is.reader);
     } catch (IOException e) {
     	...
     }
     ```

     구문을 빠져나올 때, 자동으로 close() 자동 실행

- AutoCloseable

  - 리소스를 해제할 때 자동으로 close() 메서드를 자동으로 호출하는 인터페이스

  - close() 메서드 오버라이딩

    ```
    class A implements AutoCloseable {
    	String resource;
    	A(String resource) {
    		this.resource = resource;
    	}
    	
    	public void close() throws Exception {
    		if(resource != null) {
    			resource = null;
    			System.out.println("리소스가 해제되었습니다.");
    		}
    	}
    }
    
    public class default_class {
    	public static void main(String[] args) {
    		// 1. 리소스 사용 후, finally로 수동 해제
    		A a1 = null;
    		try {
    			a1 = new A("특정 파일");
    		} catch (Exception e) {
    			System.out.println("예외 처리");
    		} finally {
    			if(a1.resource != null) {
    				a1.close();
    			} catch (Exception e) {}
    		}
    		
    		// 2. 리소스 사용 후, 자동 해제
    		try (A a2 = new A();) {
    		} catch (Exception e) {
    			System.out.println("예외 처리");
    		}
    	}
    }
    ```

    ```
    리소스가 해제되었습니다.
    리소스가 해제되었습니다.
    ```

    - 리소스 자동 해제 시, 자동으로 close() 메서드가 호출되는 것을 알 수 있다.

  