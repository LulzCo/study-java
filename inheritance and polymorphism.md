# inheritance and polymorphism

- 상속

  - ```
    class 부모 클래스{}
    class 자식 클래스{} extends 부모 클래스
    ```

  - 여러 부모 클래스 상속은 불가능 하다.

    - ```
      class 부모 클래스1{}
      class 부모 클래스2{}
      class 자식 클래스{} extends 부모 클래스1, 부모 클래스2			// 불가능
      ```

      불가능

  - 코드 중복을 방지한다.