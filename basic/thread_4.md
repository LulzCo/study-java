# thread_4

- NEW, RUNNABLE,TERMINATED

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

- TIMED_WAITING

  - Thread.sleep() 메서드를 이용한 TIMED_WAITING과 interrupt()
    
    ```
    import package_test.class_test;
    
    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println( "-- sleep() 진행 중 interrupt() 발생");
                for(long i = 0; i < 1000000000L; i++) {
                    for(long j = 0; j < 1000000000L; j++) {}
                }
            }
        }
    }
    
    public class default_class {
        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            myThread.start();
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("MyThread State : " + myThread.getState());
            
            // TIMED_WAITING
            myThread.interrupt();			// 예외 발생 시키기
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            
            System.out.println("MyThread State : " + myThread.getState());
        }
    }
    ```
    
    ```
    MyThread State : TIMED_WAITING
    -- sleep() 진행 중 interrupt() 발생
    MyThread State : RUNNABLE
    ```

    TIMED_WAITING : 주어진 시간동안 기다리는 상태
    
  - join() 메서드를 이용한 TIMED_WAITING과 interrupt()
  
    ```
    class MyThread1 extends Thread {
        @Override
        public void run() {
            for(long i = 0; i < 1000000000L; i++) {}
        }
    }
    
    class MyThread2 extends Thread {
        MyThread1 myThread1;
        public MyThread2(MyThread1 myThread1) {
            this.myThread1 = myThread1;
        }
    
        @Override
        public void run() {
            try {
                myThread1.join(3000);
            } catch (InterruptedException e) {
                System.out.println("-- join(...) 진행 중 interrupt() 발생");
                for(long i = 0; i < 1000000000L; i++) {}
            }
        }
    }
    
    public class default_class {
        public static void main(String[] args) {
            // 객체 생성
            MyThread1 myThread1 = new MyThread1();
            MyThread2 myThread2 = new MyThread2(myThread1);
            myThread1.start();
            myThread2.start();
    
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            System.out.println("MyThread1 State : " + myThread1.getState());
            System.out.println("MyThread2 State : " + myThread2.getState());
    
            // TIMED_WAITING
            myThread2.interrupt();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            System.out.println("MyThread1 State : " + myThread1.getState());
            System.out.println("MyThread2 State : " + myThread2.getState());
        }
    }
    ```
  
    ```
    MyThread1 State : RUNNABLE
    MyThread2 State : TIMED_WAITING
    -- join(...) 진행 중 interrupt() 발생
    MyThread1 State : RUNNABLE
    MyThread2 State : RUNNABLE
    ```
  
- BLOCKED

  - 공유 객체 동기화로 인한 BLOCKED 상태
  
    ```
    class MyBlockTest {
        // 공유 객체
        MyClass mc = new MyClass();;
        // 3개의 쓰레드 필드 생성
        Thread t1 = new Thread("thread1") {
            public void run() {
                mc.syncMethod();
            };
        };
        Thread t2 = new Thread("thread2") {
            public void run() {
                mc.syncMethod();
            };
        };
        Thread t3 = new Thread("thread3") {
            public void run() {
                mc.syncMethod();
            };
        };
    
        Thread t4 = new Thread("thread4") {
            public void run() {
                mc.syncMethod();
            };
        };
    
        void startAll() {
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
    
        class MyClass {
            synchronized void syncMethod() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("====" + Thread.currentThread().getName() + "====");
                System.out.println("thread1 -> " + t1.getState());
                System.out.println("thread2 -> " + t2.getState());
                System.out.println("thread3 -> " + t3.getState());
                System.out.println("thread4 -> " + t4.getState());
                for(long i = 0; i < 1000000000L; i++) {}
            }
        }
    }
    
    public class default_class {
        public static void main(String[] args) {
            MyBlockTest mbt = new MyBlockTest();
            mbt.startAll();
        }
    }
    ```
  
    ```
    ====thread1====
    thread1 -> RUNNABLE
    thread2 -> BLOCKED
    thread3 -> BLOCKED
    thread4 -> BLOCKED
    ====thread4====
    thread1 -> TERMINATED
    thread2 -> BLOCKED
    thread3 -> BLOCKED
    thread4 -> RUNNABLE
    ====thread3====
    thread1 -> TERMINATED
    thread2 -> BLOCKED
    thread3 -> RUNNABLE
    thread4 -> TERMINATED
    ====thread2====
    thread1 -> TERMINATED
    thread2 -> RUNNABLE
    thread3 -> TERMINATED
    thread4 -> TERMINATED
    ```
  
    - 쓰레드 실행 순서 : 동기화 영역에서 FILO형식을 갖고 있다.
  
      thread1은 바로 실행이 되기 때문에 제일 먼저 실행이 되고 그 다음으로 정해질 순서를 정할 때, FILO 으로 순서를 정한다.
  
    - BLOCKED : 공유 객체를 사용하지 못한 상태
  
- WAITING

  - wait() notify() 를 이용한 쓰레드 교차 실행
  
    ```
    class DataBox {
        boolean isEmpty = true;
        int data;
        synchronized void inputData(int data) {
            if(!isEmpty) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            this.data = data;
            isEmpty = false;
            System.out.println("입력 데이터 : " + data);
            notify();
        }
        synchronized void outputData() {
            if(isEmpty) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            isEmpty = true;
            System.out.println("출력 데이터 : " + data);
            notify();
        }
    }
    
    public class default_class {
        public static void main(String[] args) {
            DataBox dataBox = new DataBox();
            Thread t1 = new Thread() {
                public void run() {
                    for(int i = 0; i < 9; i++) {
                        dataBox.inputData(i);
                    }
                };
            };
            Thread t2 = new Thread() {
                public void run() {
                    for(int i = 0; i < 9; i++) {
                        dataBox.outputData();
                    }
                };
            };
    
            t1.start();
            t2.start();
        }
    }
    ```
  
    ```
    입력 데이터 : 0
    출력 데이터 : 0
    입력 데이터 : 1
    출력 데이터 : 1
    입력 데이터 : 2
    출력 데이터 : 2
    입력 데이터 : 3
    출력 데이터 : 3
    입력 데이터 : 4
    출력 데이터 : 4
    입력 데이터 : 5
    출력 데이터 : 5
    입력 데이터 : 6
    출력 데이터 : 6
    입력 데이터 : 7
    출력 데이터 : 7
    입력 데이터 : 8
    출력 데이터 : 8
    ```
  
    wait() : 현재 쓰레드 일시 정지
  
    notify() : 일시 정지 되어있던 임의 쓰레드 깨우기
  
    notifyAll() : 일시 정디 되어있는 모든 쓰레드 깨우기
  







