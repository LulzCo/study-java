# member of class

- 필드(field)

  - 클래스에 속하되 함수에는 속하지 않는 변수

  - ```
    class A(){
    	int i = 10;
    	...
    	void abc(int j){
    		int j = 10000;
    		...
    	}
    }
    ```

    int i => field

    int j => 지역 변수

    - 필드와 지역 변수는 구분된다.

  - ```
    class A{
        int m = 3;		//필드
        int n = 4;		//필드
        
        void work1(){
            int k = 5;		//지역변수
            System.out.println(k);
            work2(3);
        }
        
        void work2(int i){
            int j = 4;		//지역변수
            System.out.println(i+j);
        }
    }
    
    public class class_test{
        public static void main(String[] args){
            A a = new A();
            System.out.println(a.m);
            System.out.println(a.n);
            
            a.work1();
        }
    }
    ```

    ```
    3
    4
    5
    7
    ```

  - 필드는 초기화하지 않아도 강제 초기화가 된다.

    지역변수는 강제 초기화가 되지 않아 초기화를 하지 않으면 오류가 발생한다.

    *초기화 : 변수선언

- 함수(method)

  - public static void main()

    - public static : 자바 제어자
    - void : 함수 리턴 자료형
      - void, int, double, ...
    - main : 함수명

  - 함수 호출

    - ```
      class A(){
      	void abcPrint(){
      		System.out.println("abc");
      		return;
      	}
      }
      publuc class class_test(){
      	publuc static void main(String[] args){
      		A a = new A();
      		a.abcPrint();
      	}
      }
      ```

      1. A라는 클래스를 a라는 객체로 생성
      2. a라는 객체 안에서 abcPrint() 함수 호출

      - void의 경우 return 값이 없는 자료형이기 때문에 return만 사용
      - int, double과 같은 경우, return 값이 자료형에 맞게 리턴되어야 한다.

  - 자료형에 따른 매개변수 전달

    - 데이터가 함수 안에서 매개변수로 사용을 할 때에는 스택메모리의 값을 복사한다.
    
    - 기본 자료형 입력매개변수의 전달
    
      - ```
        public class class_test{
            public static void main(String[] args) {
                int a = 3;
                modifyData(a);
                printarray(a);
            }
            public static void modifyData(int a){
                a = 6;
            }
            public static void printarray(int a){
                System.out.println(a);
            }
        }
        ```
    
        ```
        3
        ```
    
        기본자료형은 스택메모리에 저장된 값을 복사하여 함수에서 사용하기 때문에 값이 변하지 않는 것이다.
    
    - 참조 자료형 입력매개변수의 전달
    
      - ```
        public class class_test{
            public static void main(String[] args) {
                int[] array = new int[]{1,2,3};
                modifyData(array);
                printarray(array);
            }
            public static void modifyData(int[] a){
                a[0] = 4;
                a[1] = 5;
                a[2] = 6;
            }
            public static void printarray(int[] a){
                System.out.println(Arrays.toString(a));
            }
        }
        ```
    
        ```
        [4, 5, 6]
        ```
    
        main 안에 있는 a와 modofy 안에 있는 a는 같은메모리 주소에 저장되어 있다.
    
        참조자료형은 스택메모리에 힙 메모리 주소 값을 저장하기 때문에 결국 같은 메모리 공간을 가르키고 있기 때문에 값이 변하는 것이다.
    

-----

- 함수의 오버로딩

  - 매개 변수(파라미터)는 다르나 이름은 같은 함수를 만들 수 있다.
  
  - ```
    public class class_test{
        public static void main(String[] args) {
            int a = 3;
            String b = new String("안녕하세요");
    
            print(a);
            print(b);
        }
        static void print(int a){
            System.out.println(a);
        }
        static void print(String a){
            System.out.println(a);
        }
    }
    ```
  
    ```
    3
    안녕하세요
    ```
  
- 생성자

  - 객체를 생성하는 클래스의 내부 구성요소
  
  - ```
    class A{
        A(){
            System.out.println("첫 번째 생성자");
        }
        A(int a){
            System.out.println("두 번째 생성자");
        }
        A(int a, int b){
            System.out.println("세 번째 생성자");
        }
    }
    public class class_test{
        public static void main(String[] args) {
            A a1 = new A();
            A a2 = new A(3);
            A a3 = new A(3, 5);
        }
    }
    ```
  
    ```
    첫 번째 생성자
    두 번째 생성자
    세 번째 생성자
    ```
  
- this 키워드와  this() 함수

  - this 키워드
  
    - 클래스 내부에 있는 변수를 알려주는 기능
  
    - ```
      class A{
          int m;
          int n;
          void init(int m, int n){
              m = m;
              n = n;
          }
      }
      
      class B{
          int m;
          int n;
          void init(int m, int n){
              this.m = m;
              this.n = n;
          }
      }
      
      public class class_test{
          public static void main(String[] args) {
              A a = new A();
              B b = new B();
      
              a.init(1,2);
              b.init(3,4);
              System.out.println(a.m);
              System.out.println(a.n);
              System.out.println(b.m);
              System.out.println(b.n);
          }
      }
      ```
  
      ```
      0
      0
      3
      4
      ```
  
  - this() 함수
  
    - 클래스 내부 생성자 호출
  
    - 함수 안에서 사용 불가능
  
    - ```
      class A{
          A(){
              System.out.println("첫 번째 생성자");
          }
          A(int m){
              this();
              System.out.println("두 번째 생성자");
          }
      }
      public class class_test{
          public static void main(String[] args) {
              A a1 = new A();
              A a2 = new A(3);
          }
      }
      ```
  
      ```
      첫 번째 생성자
      첫 번째 생성자
      두 번째 생성자
      ```
  
      