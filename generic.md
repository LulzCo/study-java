# generic

- 제네릭 없이 여러 객체를 저장하는 클래스 작성하기

  상품이라는 클래스 안에 사과와 연필이라는 객체를 담으려고 할 때

  ```
  // Apple 클래스와 Apple 클래스를 담을 수 있는 Goods1 클래스
  class Apple {}
  class Goods1 {
  	private Apple apple = new Apple();
  	public Apple getApple() {
  		return apple;
  	}
  	public void setApple(Apple apple) {
  		this.apple = apple;
  	}
  }
  
  // Pencil 클래스와 Pencil 클래스를 담을 수 있는 Goods2 클래스
  class Pencil {}
  class Goods2 {
  	private Pencil pencil = new pencil();
  	public Pencil getPencil() {
  		return pencil;
  	}
  	public void setPencil(Pencil pencil) {
  		this.pencil = pencil;
  	}
  }
  
  public class default_class {
  	public static void main(String[] args) {
  		// Goods1을 이용해 Apple 객체를 추가하거나 가져오기
  		Goods1 goods1 = new Goods1();
  		goods1.setApple(new Apple());					// Apple 타입만 입력 가능
  		Apple apple = goods1.getApple();
  		
  		//Goods2를 이용해 Pencil 객체를 추가하거나 가져오기
  		Goods2 goods2 = new Goods2();
  		goods2.setPencil(new Pencel());
  		Pencil pencil = goods2.getPencil();
  	}
  }
  ```

  여러 타입이 들어갈 수 없기에 여러 Goods 클래스를 만들어줘야 한다.

- Generic Class

  Goods에 여러 타입 객체 저장하기

  1. 필드의 타입을 모든 객체를 저장할 수 있는 Object로 정의

     ```
     class Apple {}
     class Pencil {}
     
     class Goods {
     	private Object object = new Object();
     	public Object get() {
     		return object;
     	}
     	public void set(Object object) {
     		this.object = object;
     	}
     }
     
     public class default_class {
     	public static void main(String[] args) {
     		Goods goods1 = new Goods();
     		goods1.set(new Apple());
     		Apple apple = (Apple)goods1.get();
     		
     		Goods goods2 = new Goods();
     		goods2.set(new Pencil());
     		Pencil pen = (Pencil)goods2.get();
     	}
     }
     ```

     - 객체를 저장할 때는 상관없지만 저장된 데이터를 각각의 타입으로 꺼내오기 위해서는 저장된 형태로 캐스팅 필수

     - 필드 자체가 Object 타입이기 때문에 get() 메서드로 가져오는 타입 또한 항상 Object 타입이다.

       따라서 set() 메서드로 가져온 타입으로 get() 메서드를 불러올 수 있다.

       - ClassCastException 발생

         ```
         Goods goods3 = new Goods();
         goods.set(new Apple());
         Pencil pen = (Pencil)goods3.get();
         ```

  2. 제네릭 클래스를 사용하여 다양한 객체 저장

     - 제네릭 타입 1개를 가진 제네릭 클래스의 선언 및 활용

       ```
       class MyClass<T> {
           private T t;
           public T get() {
               return t;
           }
           public void set(T t) {
               this.t = t;
           }
       }
       
       public class default_class {
           public static void main(String[] args) {
               MyClass<String> mc1 = new MyClass<String>();
               mc1.set("안녕");
               System.out.println(mc1.get());
       
               MyClass<Integer> mc2 = new MyClass<Integer>();
               mc2.set(100);
               System.out.println(mc2.get());
       
           }
       }
       ```

       ```
       안녕
       100
       ```

     - 제네릭 타입 2개를 가진 제네릭 클래스 선언 및 활용

       ```
       class KeyValue<K, V> {
           private K key;
           private V value;
       
           public K getKey() {
               return key;
           }
           public void setKey(K key) {
               this.key = key;
           }
       
           public V getValue() {
               return value;
           }
           public void setValue(V value) {
               this.value = value;
           }
       }
       
       public class default_class {
           public static void main(String[] args) {
               // K(key)는 String, V(value)는 Integer
               KeyValue<String, Integer> kv1 = new KeyValue<>();
               kv1.setKey("사과");
               kv1.setValue(1000);
               String key1 = kv1.getKey();
               int value1 = kv1.getValue();
               System.out.println("key1 : " + key1 + ", value1 : " + value1);
       
               // K(key)는 Integer, V(value)는 String
               KeyValue<Integer, String> kv2 = new KeyValue<>();
               kv2.setKey(404);
               kv2.setValue("Not Found(요청한 페이지를 찾을 수 없습니다.)");
               int key2 = kv2.getKey();
               String value2 = kv2.getValue();
               System.out.println("key2 : " + key2 + ", value2 : " + value2);
       
               // K(key)는 String, V(value)는 Void
               // Void는 변수를 사용하지 않을 때
               KeyValue<String, Void> kv3 = new KeyValue<>();
               kv3.setKey("Hello, Worlds");
               String key3 = kv3.getKey();
               System.out.println("key3 : " + key3);
           }
       }
       ```

       ```
       key1 : 사과, value1 : 1000
       key2 : 404, value2 : Not Found(요청한 페이지를 찾을 수 없습니다.)
       key3 : Hello, Worlds
       ```

-----

- Generic Method



