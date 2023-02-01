import java.lang.System;
import static java.lang.System;
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
        // 파일들은 모두 unnamed package에 속해있기 때문.
    }
}
/*
class test4_1 {
    public static void main(String [] args){
        
    }
}
class test4_1 {
    public static void main(String [] args){
        
    }
}
class test4_1 {
    public static void main(String [] args){
        
    }
}
class test4_1 {
    public static void main(String [] args){
        
    }
}
 */