- 프로젝트

  - bin : src에 저장된 source code를 바이트 코드로 저장
  - src : 패키지 및 source code 저장
    - package : class source code 저장
      - class : source code

- class

  - class는 하나의 public class만을 정의할 수 있다.

  - 다른 클래스를 추가하고 싶다면 public class가 아니라 class만 사용

  - main_test.java

    ```
    public class main_test{
    
    }
    
    class test_A{
    
    }
    
    class test_B{
    
    }
    ```

-----

- 출력 시 포멧 자료형

  - %d : 10진수

  - %s : 문자열

  - %f : 실수

  - %o : 8진수

  - %x : 16진수

  - %4.2 : 전체 자릿수.소숫점 자릿수

  - ex)

    입력

    ```
    public class main_test{
    	system.out.println("%d", 30);
    	system.out.println("%s", "Hello, World");
    	system.out.println("%f", 4);
    }
    ```

     출력

    ```
    30
    Hello, World
    4.000000
    ```

    

