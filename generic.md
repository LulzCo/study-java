# generic

- 제네릭 없이 여러 객체를 저장하는 클래스 작성하기

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
  	}
  }
  ```

  

