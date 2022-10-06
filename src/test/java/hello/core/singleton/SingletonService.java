package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static이면 하나만 만들어짐.

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){ //이렇게 private으로 만들면 외부에서 못만든다.

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

/*      public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
        //이렇게하면 막 만들어버릴수있다
        //-> 그래서 private 사용
    }*/

}
