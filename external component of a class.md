# external component of a class

- package

  - 비슷한 목적으로 생성된 클래스 파일들을 한 곳에 모아둔 폴더

    - .java 파일 생성 시, 패키지 안에서 생성한 것과 패키지 없이 기본으로 생성한 것의 차이

      - 패키지 안에서 생성한 경우

        - .java 안에 가장 첫 줄에 

          ```
          package 클래스명
          ```

      - 패키지 밖에서 생성한 경우

        - package가 들어가지 않는다.

- import

  - package는 밖으로 보내는 느낌이면 import는 사용하기 위해 가져오는 느낌

  - 패키지를 가져오는 방법은 두 가지가 있음

  - package_test/class_test.java

    ```
    package package_test
    
    public class class_test{
        public void print(int x){
            System.out.println(x);
        }
        public void print(String x){
            System.out.println(x);
        }
    }
    ```

    public을 사용해야만 외부에서 사용 가능하다.

    1. full name

       default_class.java

       ```
       public class default_class {
           public static void main(String[] args){
               package_test.class_test class_test = new package_test.class_test();
               class_test.print(3);
               class_test.print("Hello, world");
           }
       }
       ```

       ```
       3
       Hello, world
       ```

    2. import

       default_class.java

       ```
       import package_test.class_test;
       public class default_class {
           public static void main(String[] args){
               class_test class_test = new class_test();
               class_test.print(3);
               class_test.print("Hello, world");
           }
       }
       ```

       ```
       3
       Hello, world
       ```

       import는 실제로 가져오는 파일은 .java가 아니다.

       bin에 있는 .class 파일을 가져오는 것이다.

       따라서 *로 가져오게 된다면 혼란이 오지 않도록 조심해야 한다.

-----

- 외부 클래스
  - 외부에서 사용할 수 있도록 public을 사용한다.
  - .java 클래스 파일은 하나의 public 클래스만을 허용한다.
