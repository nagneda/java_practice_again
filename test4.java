import java.lang.System;
 class Point3dtest {
    public static void main(String [] args){
        Point3d p = new Point3d(3,4,6);
        Point3d pp = new Point3d();
        System.out.println(p.getlocation());
    }
}

class Point {
    int x=10, y=11;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
        }
    Point(){}
    String getlocation(){
        return "x : "+x+" y : "+y;
    }
}

class Point3d extends Point{
    int z;
    Point3d(){
        System.out.println(this.x + ""+this.y+this.z); // 상속받은 순간부터 그냥 그 값을 가지고 있음. Point 클래스가 당연하게 x y의 값을 갖고 있는 것과
        //같은 원리인 듯
    }


    Point3d(int x,int y, int z){
        
       //super(); 생략
        super();  //생성자를 통해 가는 것도 꼭 생성자 내부의 초기화뿐만 아니라 명시적 초기화를 포함하는 것인가
        //상속받은 순간부터 그냥 명시적초기화는 돼있는 상태인가
        System.out.println(this.x + ""+this.y+this.z); 
        this.x = x;
        this.y = y;
        this.z = z;
    }
    String getlocation(){
        return super.getlocation()+" z : "+z;
    }

}
class loadingq{
    public static void main(String [] args){
        loading.add(4,6); // test3.java파일에 있는 loading클래스를 import 없이 사용할 수 있음. 패키지가 선언되지 않은 클래스
        // 파일들은 모두 unnamed package에 속해있기 때문. 같은 패키지 내에 있는 클래스끼리는 import없이 패키지명 생략 가능하다.
    }
}






class test4_1 {
    public static void main(String [] args){
        
    }
}

class Carr{
    String color = "black";
    int door = 4;

    void drive(){System.out.println("driverr");}

}

class FireEngine extends Carr{
    String type = "ambulance";

    void siren(){System.out.println("dpdpdpdpdpd");}
}

class CastingTest{
    public static void main(String [] args){
        Carr c1 = null;
        FireEngine f1 = new FireEngine();
        FireEngine f2 = null;
        
        
        c1 = new FireEngine();// c1 = (Car)new FireEngine();  // c1 참조변수가 사용할 수 있는 멤버는 color, door, siren뿐이므로 FireEngine타입의 인스턴스를
        //저장해도 아무런 문제가 발생하지 않는다. 
        f2 = (FireEngine)c1; // f1은 Car의 자손클래스의 참조변수로써 Car의 인스턴스를 f1에 저장하게 되면 f1은 접근 범위가 넓지만 인스턴스의 범위는
        //좁기 때문에 형변환을 해주어야 한다(조상 > 자손은 형변환 해줘야하고 자손 > 조상은 생략가능)
        // 만약에 c1을 초기화할때 FireEngine이 아닌 Carr로 했다면 f2 = (FireEngine)c1 실행시
        //에러가 발생한다. 이유는 컴파일시에는 실행 후 생성될 인스턴스에 대한 오류를 감지하지 못하는데
        // f2는 fireengine타입의 참조변수이지만 c1은 조상클래스 참조변수기 때문에 참조할 수 없다.
        
        f2.drive();
        f2.siren();  
        new FireEngine().siren();
    }
}

class CastingTest2 {
    public static void main(String [] args){
        Carr car = new Carr();
        car = new FireEngine();
        FireEngine fe = null;

        fe = (FireEngine)car;
    }
}

class InstanceOfTest {
    public static void main(String [] args){
        Carr c = new FireEngine(); //참조변수의 타입과 관계없이 인스턴스가 어떤 타입인지를
        //검사하는 것이기 때문에 Carr c이든 FireEninge f이든 상관없다.

        if ( c instanceof FireEngine){
            System.out.println("fireengine");
        }
    
        if ( c instanceof Carr){
            System.out.println("Carr");
        }
        if ( c instanceof Object){
            System.out.println("Object");
        }
    }


}

class Childs extends Parents{
  
}

class Parents{
    int x = 100;
    void method(){System.out.println("parents method");}
    
}

class BindingTest{
    public static void main (String [] args){
        Parents p = new Childs();
        Childs c = new Childs();

        System.out.println(c.x);
        System.out.println(p.x);

        p.method();
        c.method();

    }
}
/* 


 */