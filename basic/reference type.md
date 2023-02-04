# reference type

-  참조자료형
  - 기본자료형과는 다르게 값이 힙 메모리에 저장이 된다.
  - 기본자료형에 값을 저장할 경우 스택메모리에 저장
  - 참조자료형은 힙 메모리에 값을 저장하고 스택메모리에 힙 메모리의 주소 값을 저장

-----

- 자바의 메모리 구조

  - 1. 클래스 영역, 정적 영역, 상수 영역, 메서드 영역

    2. 스택 영역

    3. 힙 영역

-----

- 배열 생성

  1. ```
     int[] array1 = new int[3]
     
     int[] array2;
     array2 = new int[3];
     ```

  2. ```
     int array3[] = new int[3];
     
     int array4[];
     array4 = new int[3];
     ```

     - 두 가지 방법이 존재

     - new : 힙 메모리에 저장

- 값 입력

  - ```
    a[0]  = 0;
    a[1]  = 1;
    a[2]  = 2;
    ```

- 배열과 값 동시 입력

  - ```
    int array5[] = new int[3]{0,1,2};
    ```

    - 중괄호를 사용해야 한다.
    
    - 다음과 같이 분리를 할 수는 없다.
    
      - ```
        int[] a;
        a = {3,4,5};
        ```
  
- 배열의 for 반복문 활용

  - "변수.length" 와 "for-each"
  
    ```
    int[] a = new int[100];
    for (int i=0; i<a.length; i++){
    	a[i] = i+1;
    }
    
    for(int k:a){
    	System.out.println(k);
    }
    
    System.out.println(Arrays.toString(a));
    ```
  
    ```
    1
    2
    3
    ...
    100
    [1, 2, 3, ... 100]
    ```
  
- 2차원 배열

  - 초기화
  
    ```
    int[][] a;
    int[] b[];
    int c[][];
    ```
  
  - 메모리 구조
  
    ```
    int[][] a = new int[2][2];
    a[0][0] = 0;
    a[0][1] = 1;
    a[1][0] = 2;
    a[1][1] = 3;
    
    System.out.println(a);
    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a.length);
    ```
  
    ```
    a의 주소			//주소를 따라가면 a[0]과 a[1]의 주소 값이 저장되어 있다.
    a[0]의 주소	//주소를 따라가면 a[0][0], a[0][1]의 값이 저장되어 있다.
    a[1]의 주소	//주소를 따라가면 a[1][0], a[1][1]의 값이 저장되어 있다.
    2					 //a[0]의 주소, a[1]의 주소, 이렇게 두 가지만 저장되어 있기 때문에 2
    ```
  
    - 스택 메모리에는 a의 힙 메모리 주소 값 저장
    - 주소를 따라가면 a[0]과 [1]의 주소값들이 저장되어 있음
    - 다시 그 주소를 따라가면 값들이 저장되어 있음
  
  - 열 성분은 각각 다를 수 있다.
  
    - ```
      int[][] a = new int[3][];
      a[0] = new int[5];
      a[1] = new int[2];
      ```
  
  - 선언과 대입 동시
  
    - ```
      int[][] a = new int[][]{{1,2,3}, {4,5,6}};
      
      int[][] b;
      b = new int{{1,2,3}, {4,5,6}};
      
      int[][] c = {{1,2,3}, {4,5,6}};
      ```
  
  - 반복문을 이용한 배열 출력
  
    - ```
      int[][] array1 = new int[][]{{1,2,3}, {10,20,30,40}};
      
      System.out.println("for 이중 반복문을 이용한 출력");
      for(int i=0; i<array1.length; i++){
      	for(int j=0; j<array1[i].length; j++){
      		System.out.println(array1[i][j]);
      	}
      }
      System.out.println();
      System.out.println("for-each 이중 반복문을 이용한 출력");
      for(int[] array_i:array1){
      	for(int k:array_i){
      		System.out.println(k);
      	}
      }
      ```
    
      ```
      for 이중 반복문을 이용한 출력
      1
      2
      3
      10
      20
      30
      40
      
      for-each 이중 반복문을 이용한 출력
      1
      2
      3
      10
      20
      30
      40
      ```
    
      
    
  

-----

- 기본자료형과 참조자료형의 변수 복사 차이

  - 기본자료형
  
    ```
    int value1 = 3;
    int value2 = value1;
    
    int value2 = 7;
    
    System.out.println(value1);
    System.out.println(value2);
    ```
  
    ```
    3
    7
    ```
  
    - value1의 값은 스택 메모리에 저장
    - value2는 스택메모리에 저장된 value1의 값을 그대로 복사
  
  - 참조자료형
  
    ```
    int[] array1 = new int[]{3,4,5};
    int[] array2 = array1;
    
    array2[0] = 10;
    
    System.out.println(array1[0]);
    System.out.println(array2[0]);
    ```
  
    ```
    7
    7
    ```
  
    - array1의 값은 힙 메모리에 저장이 되고 스택 메모리에 힙 메모리 주소를 저장
    - array2는 스택메모리에 저장된 value1의 힙 메모리 주소 값을 복사
    - array1과 array2는 결국 하나의 같은 힙 메모리 주소 값을 저장

-----

- main() 함수의 입력매개변수

  ```
  public static void main(String[] args)
  ```

  콘솔 또는 에디터에서 데이터를 넣을 수 있다.

  main 함수 안에서 args[0]과 같은 배열의 형태로 데이터를 출력시킬 수 있다.

-----

- 문자열 생성

  ```
  String str1 = new String("문자열");
  
  String str2 = "문자열";
  ```

- String은 클래스이다.

  - 배열과의 차이

    - String 클래스
      - 메모리의 클래스 영역에 바이트 코드로 로딩을 한 후
      - 스택메모리에 힙 메모리 주소 저장
      - 힙 메모리 주소에 맞는 곳에 값을 저장
      - 값이 변경될 경우 새로운 객체 생성
    - 배열
      - 스택 메모리에 바로 힙 메모리 주소 저장
      - 힙 메모리에 값을 저장
      - 값이 변경될 경우 힙 메모리에 있는 값이 변경

  - ```
    String str1 = new String("안녕하세요");
    String str2 = str1;
    System.out.println(str1);
    System.out.println(str2);
    str1 = "Hello, World";
    System.out.println(str1);
    System.out.println(str2);
    System.out.println();
    
    int[] array1 = new int[]{1,2,3};
    int[] array2 = array1;
    System.out.println(String.format("%d %d %d", array2[0], array2[1], array2[2]));
    System.out.println(String.format("%d %d %d", array1[0], array1[1], array1[2]));
    array1[0] = 4;
    array1[1] = 5;
    array1[2] = 6;
    System.out.println(String.format("%d %d %d", array2[0], array2[1], array2[2]));
    System.out.println(String.format("%d %d %d", array1[0], array1[1], array1[2]));
    ```

    ```
    안녕하세요					//str1
    안녕하세요					//str2
    Hello, World		//str1
    안녕하세요					//str2
    
    1 2 3						//array1
    1 2 3						//array2
    4 5 6						//array1
    4 5 6						//array2
    ```

  - String 클래스의 주요 함수

    - ```
      length()					//문자열 길이 리턴
      charAt()					//특정 인덱스 문자 리턴
      indexOf()					//특정 문자를 앞에서부터 찾아 리턴
      lastindexOf()			//특정 문자를 뒤에서부터 찾아 리턴
      String.valueOf()	//기본자료형을 문자열로 바꾸는 함수
      concat()					//2개의 문자열 연결(+와 같은 기능)
      getBytes()				//문자열을 byte 단위로 변환
      toCharArray()			//문자열을 char array로 변환
      toLowerCase()			//소문자 변환
      toUpperCase()			//대문자 변환
      replace()					//문자열 대체
      substring()				//문자열을 일부만 포함하는 새로운 객체 생성
      split()						//특정 기호 기준으로 문자열 분리
      trim()						//문자열 좌우 공백 제거
      equals()					//두 문자열의 위치값이 아닌 실제 데이터 값 비교(대소문자 구분)
      equalsIgnoreCase()//두 문자열의 위치값이 아닌 실제 데이터 값 비교(대소문자 구분x)
      ```

      