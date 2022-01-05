# data type

- 자료형 선언

  - 자료형 변수명;
    변수명 = 변수값;

    or

    자료형 변수명 = 변수값;

  - ```
    int a;
    a = 3;
    
    int b = 5;
    ```

-----

- 변수명 지을 때 권장 사항 : 낙타 표기법

  - 하나의 단어일 경우 : 소문자로만
    - avg, name, ...
  - 두 개 이상의 단어일 경우 : 첫 단어 다음으로 오는 단어의 첫 글자를 대문자로
    - myAvg, myName

- 상수명 지을 때 권장 사항

  - 대문자 표기

  - 두 단어 이상인 경우 '_' 사용

    - MY_NAME, MY CLASS

  - ```
    final int MY_NAME;
    ```

- 함수명(method) 지을 때 권장 사항

  - 낙타표기법

-----

- 자료형 종류
  - 기본 자료형
    - boolean
    - byte, short, int, long
    - float, double
    - char
  - 참조 자료형
    - 객체: Object
      - 배열, 클래스, 인터페이스
  - 차이
    - 모두 스택 메모리에 생성
    - 기본 자료형
      - 스택 메모리에 변수값 그대로 생성
    - 참조 자료형
      - 힙 메모리에 변수값 생성
      - 힙 메모리에 저장된 공간의 주소를 스택 메모리에 생성

-----

- 자료형 간의 타입 변환

  - ```
    float a = 30.1234;
    System.out.println(a);
    a = (int)a;
    System.out.println(a);
    ```

    ```
    30.1234
    30
    ```

  - 문자열을 정수로
  
    - ```
      Integer.parseInt(문자열);
      ```
  
  - 문자열을 실수로
  
    - ```
      Double.parseDouble(문자열);
      ```
  
  - 정수를 문자열로
  
    - ```
      String.valueOf(정수);
      ```
  
  - 실수를 문자열로
  
    - ```
      String.valueOf(실수);
      ```
  
      