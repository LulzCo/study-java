# control statement

- 제어문 종류
  - if
  - switch
  - for
  - while
  - do~while
- keyword
  - break
  - continue

-----

- if 

  - ```
    public static void main(String[] args){
    	int a;
    	int b;
    
    	a = 3;
    	b = 5;
    
    	if(a==b) {
    		System.out.println("a==b 일치");
    	}else if(a == 4){
    		System.out.println("a: 3");
    	}else{
    		System.out.println(String.format("b: %d", b));
    	}
    }
    ```

- switch

  - ```
    package package_test;
    
    public class class_test {
        public static void main(String[] args) {
            int a;
    
            a = 3;
    
            switch (a){
                case 1:
                    System.out.println(String.format("a : %d", a));
                    System.out.println("a1");
                    break;
                case 2:
                    System.out.println(String.format("a : %d", a));
                    System.out.println("a2");
                    break;
                case 3:
                    System.out.println(String.format("a : %d", a));
                    System.out.println("a3");
                    break;
                case 4:
                    System.out.println(String.format("a : %d", a));
                    System.out.println("a4");
                    break;
                case 5:
                    System.out.println(String.format("a : %d", a));
                    System.out.println("a5");
                    break;
            }
        }
    }
    ```

    ```
    a : 3
    a3
    ```

  - break를 하지 않으면 만족하는 순간부터 계속 실행된다.

- for

  - ```
    public class class_test {
        public static void main(String[] args) {
            for(int i=0; i<3; i++){
                System.out.println(String.format("i : %d", i));
                if(i==1){
                    break;
                }
            }
        }
    }
    ```

    ```
    i : 0
    i : 1
    ```

- while

  - ```
    public class class_test {
        public static void main(String[] args) {
            int a = 0;
            while (a<5){
                System.out.println(a);
                a++;
            }
        }
    }
    ```

    ```
    0
    1
    2
    3
    4
    ```