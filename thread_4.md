# thread_4

- 쓰레드의 상태 값 가져오기

  - ```
    public class default_class {
        public static void main(String[] args) {
            // 쓰레드 상태 저장 클래스
            Thread.State state;
    
            // 1. 객체 생성(NEW)
            Thread myThread = new Thread() {
                @Override
                public void run() {
                    // 시간 지연
                    for(long i = 0; i < 1000000000L; i++) {}
                }
            };
            state = myThread.getState();
            System.out.println("myThread state : " + state);
    
            // 2. myThread 시작
            myThread.start();
            state = myThread.getState();
            System.out.println("myThread state : " + state);
    
            // 3. myThread 종료
            try {
                myThread.join();			// myThread 실행이 완료될 때까지 main 쓰레드 일시 정지
            } catch (InterruptedException  e) {}
            state = myThread.getState();
            System.out.println("myThread state : " + state);
        }
    }
    ```

    ```
    myThread state : NEW
    myThread state : RUNNABLE
    myThread state : TERMINATED
    ```

    - NEW : 생성
    - RUNNABLE : 실행
    - TERMINATED : 종료

- Runnable 상태에서 yield() 메서드를 이용한 CPU 사용 양보

  - ```
    import package_test.class_test;
    
    class MyThread extends Thread {
        boolean yieldFlag;ㅎ
        @Override
        public void run() {
            while(true) {
                if(yieldFlag) {
                    Thread.yield();
                } else {
                    System.out.println(getName() + " 실행");
                    for(long i = 0; i < 1000000000L; i++) {}
                }
            }
        }
    }
    
    public class default_class {
        public static void main(String[] args) {
            MyThread thread1 = new MyThread();
            thread1.setName("thread1");
            thread1.yieldFlag = false;
            thread1.setDaemon(true);
            thread1.start();
    
            MyThread thread2 = new MyThread();
            thread2.setName("thread2");
            thread2.yieldFlag = true;
            thread2.setDaemon(true);
            thread2.start();
    
            // 6초 지연(1초마다 한 번씩 양보)
            for(int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                thread1.yieldFlag = !thread1.yieldFlag;
                thread2.yieldFlag = !thread2.yieldFlag;
            }
        }
    }
    ```

    ```
    thread1 실행
    thread1 실행
    thread1 실행
    thread1 실행
    thread2 실행
    thread2 실행
    thread2 실행
    thread2 실행
    thread1 실행
    thread1 실행
    ...(4번씩 출력 후 6초 뒤 종료)
    ```

    - 데몬 쓰레드로 설정한 이유
      - 쓰레드 클래스에서 무한 반복이 실행이 되므로 데몬으로 설정


