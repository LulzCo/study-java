# thread_2

- 쓰레드의 속성

  ```
  public class default_class {
  	public static void main(String[] args) {
  		// 객체 참조하기, 쓰레드 개수 가져오기
  		Thread curThread = Thread.currentThread();
  		System.out.println("현재 스레드 이름 : " + curThread.getName());
  		System.out.println("동작 쓰레드 갯수 : " + Thread.activeCount());
  		
  		// 쓰레드 이름 자동 지정
  		for(int i = 0; i < 3; i++) {
  			Thread thread = new Thread();
  			System.out.println(thread.getName());
  			thread.start();
  		}
  		
  		// 쓰레드 이름 직접 지정
  		for(int i = 0; i < 3; i++) {
  			Thread thread = new Thread();
  			thread.setName(i + "번째 쓰레드");
  			System.out.println(thread.getName());
  			thread.start();
  		}
  		
  		// 쓰레드 개수 가져오기
  		System.out.println("동작하는 쓰레드의 개수 : " + Thread.activeCount());
  	}
  }
  ```

  ```
  현재 스레드 이름 : main
  동작 쓰레드 갯수 : 2
  Thread-0
  Thread-1
  Thread-2
  0번째 쓰레드
  1번째 쓰레드
  2번째 쓰레드
  동작하는 쓰레드의 개수 : 3
  ```

- 쓰레드의 우선순위

  ```
  class MyThread extends Thread {
      @Override
      public void run() {
              System.out.println(getName() + " 우선순위 : " + getPriority());
              try {
                  sleep(5000);
                  System.out.println(getName() + " end");
              } catch (InterruptedException e) {
                  System.out.println("InterruptedException");
              }
      }
  }
  
  public class default_class {
      public static void main(String[] args) {
          // CPU 코어 수
          System.out.println("코어 수 : " + Runtime.getRuntime().availableProcessors());
  
          // 우선순위 자동 지정
          for(int i = 0; i < 3; i++) {
              Thread thread = new MyThread();
              thread.start();
          }
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {}
  
          // 우선순위 직접 지정
          for(int i = 0; i < 10; i ++) {
              Thread thread = new MyThread();
              thread.setName(i + "번째 쓰레드");
              if(i == 9) thread.setPriority(10);
              thread.start();
          }
      }
  }
  ```

  ```
  코어 수 : 10
  Thread-2 우선순위 : 5
  Thread-1 우선순위 : 5
  Thread-0 우선순위 : 5
  0번째 쓰레드 우선순위 : 5
  1번째 쓰레드 우선순위 : 5
  2번째 쓰레드 우선순위 : 5
  3번째 쓰레드 우선순위 : 5
  4번째 쓰레드 우선순위 : 5
  5번째 쓰레드 우선순위 : 5
  6번째 쓰레드 우선순위 : 5
  7번째 쓰레드 우선순위 : 5
  8번째 쓰레드 우선순위 : 5
  9번째 쓰레드 우선순위 : 10
  Thread-0 end
  Thread-2 end
  Thread-1 end
  0번째 쓰레드 end
  5번째 쓰레드 end
  9번째 쓰레드 end
  1번째 쓰레드 end
  7번째 쓰레드 end
  2번째 쓰레드 end
  4번째 쓰레드 end
  6번째 쓰레드 end
  3번째 쓰레드 end
  8번째 쓰레드 end
  ```

  



