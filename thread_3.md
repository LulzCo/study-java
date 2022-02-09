# thread_3

- 쓰레드의 동기화

  - 동기화(synchronized) : 하나의 작업이 완전히 완료된 후 다른 작업을 수행하는 것
  - 비동기(asynchronous) : 하나의 작업 명령 이후 완료 여부와 상관없이 바로 다음 작업 명령을 수행하는 것

- 필요성 : 여러 쓰레드에서 공유하고 싶은 객체가 필요한 경우 동기화를 사용

- 동기화를 사용하지 않았을 때 발생하는 문제

  ```
  // 공유 객체
  class MyData {
      int data = 3;
  
      public void plusData() {
          int mydata = data;
  
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {}
  
          data = mydata + 1;
      }
  }
  
  // 공유 객체를 사용하는 쓰레드
  class PlusThread extends Thread {
      MyData myData;
  
      public PlusThread(MyData myData) {
          this.myData = myData;
      }
  
      @Override
      public void run() {
          myData.plusData();
          System.out.println(getName() + "실행 결과 : " + myData.data);
      }
  }
  
  public class default_class {
      public static void main(String[] args) {
          // 공유 객체 생성
          MyData myData = new MyData();
  
          // plusThread 1
          Thread plusThread1 = new PlusThread(myData);
          plusThread1.setName("plusThread1");
          plusThread1.start();
  
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {}
  
          //plusThread 2
          Thread plusThread2 = new PlusThread(myData);
          plusThread2.setName("plusThread2");
          plusThread2.start();
      }
  }
  ```

  ```
  plusThread1실행 결과 : 4
  plusThread2실행 결과 : 4
  ```

  객체를 공유하지 못하고 있음을 알 수 있다.