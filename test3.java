import java.util.*;

class Tv{
    int channel;
}

class TvTest{
    public static void main( String [] args){

        Tv t1 = new Tv();
        Tv t2 = new Tv();
        boolean [] bool = new boolean[5];
        System.out.println(Arrays.toString(bool));

        System.out.println(t1.channel);
        System.out.println(t2.channel);
        t1.channel = 7;
        System.out.println(t1.channel);
        t1=t2;// 여기서부터 t1은 기존에 참조하고 있던 인스턴스 대신 t2가 참고하고 있는 인스턴스를 같이 참조하게끔 바뀌게 됨.
        System.out.println(t1.channel);

    }
}


class MyMath{
    long add(long a, long b){
        return a+b;
    }

    long subtract(long a, long b){return a-b;}
    long multiply(long a, long b){return a*b;}
    double divide(double a, double b){return a/b;}
    double divide2(long a, long b){return a/b;}
}

class MyMathTest{
    public static void main(String [] args){
        MyMath mm = new MyMath();
        System.out.println(mm.add(3,5));
        System.out.println(mm.multiply(3,5));
        System.out.println(mm.divide(3,5)); // 자동형변환됨
        System.out.println(mm.divide2(3,5)); // 나누기 계산은 long타입으로 진행됐으나 0을 double로 형변환해서 0.0이 출력.
    }
}

class CallStack{
    public static void main(String [] args){
        System.out.println("main 메서드실행");
        firstmethod();
        System.out.println("main 메서드종료");
    }
    static void firstmethod(){
        System.out.println("first 메서드실행");
        secondmethod();
        System.out.println("first 메서드종료");
    }
    static void secondmethod(){
        System.out.println("second 메서드실행");
        System.out.println("second 메서드실행");
    }
}

class test3_1{
    
    public static void main(String [] args){

        int [] arr = {4,6,3,1,7,5};
        printArr(arr); //메서드화 시키면 코드의 중복이 줄어들고 재사용성이 좋아지며 유지보수도 쉬워진다.
        sortArr(arr);
        printArr(arr);
    }

    static void printArr(int[] arr){
        //for문을 쓰든 Array.toString을 쓰든 향상된 for문을 쓰든 
 
        System.out.println(Arrays.toString(arr));
    }
    static void sortArr(int [] arr){
        for(int i=0 ; i<arr.length-1 ; i++){
            for(int j=0; j<arr.length-1-i ; j++)
                if(arr[j]<arr[j+1]) continue;
                else{ 
                    int tmp = 0;
                    tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
        }   
    }
}
class Data { int x;}
class test3_2{
    public static void main(String [] args){
        Data d1 = new Data();
        d1.x=10;
        Data d2 = copy(d1);

        System.out.println("d1.x = "+d1.x);
        System.out.println("d2.x = "+d2.x);
    }

    static Data copy(Data d){
        Data tmp = new Data();
        return tmp; //이 메서드에서 생성한 Data객체의 tmp라는 새로운 참조변수를 return 값으로 주고 d2 참조변수에 tmp 참조변수 주소를 저장
    }
}

class test3_3{
    public static void main(String [] args){
        int n = 20;
        long result = 0;
        for(int i=1; i<=n; i++){
            result = factorial(i);
            System.out.printf("%d!의 값은 %d입니다 %n",i,result);
        }
    }

    static long factorial(int n){
        if ( n==1 ) return 1;
        return n* factorial(n-1);
    }
}

class MyMath2{
    long a, b;
    long add(){return a+b;}
    static long add2(){
        MyMath2 mm = new MyMath2();    
        return mm.a+mm.b;
    }

    long add2(int c, long d){
        return c+d;
    }

    long add2(long c, int d){
        return c+d;
    }

    void test(){
        add2(3l,3);
        add2(4,4l);
    }
    long add3(int c, byte d){
        return c+d;
    }
    long add3(byte c, int d){
        return c+d;
    }
    void test2(){
        add3(3,(byte)5);
        add3((byte)4,4);
    }
}

class test3_4{
    public static void main(String [] args){
        
        String [] str1 = {"100","200","300"};
        
        System.out.println(test("--",str1));
        System.out.println(test("++",new String[]{"111","22"}));

        
    }
    static String test(String tmp1 , String... args){
        String result = "";
        for ( String aaa : args){
            result+= tmp1 + aaa;
        }
        return result;
    }
}


class Car{
    String color;
    String gear;
    int door;

    Car(){ // default constructor
        this("white","auto",4); // 오버로딩된 생성자로 이동한 후 인스턴스 변수들이 초기화 된다. 
    
    /*
    this.color = "white";
    this.gear = "auto";
    this.door = 4;

    여기서는 인스턴스 변수들과 동일한 이름을 가진 매개변수가 주어진 것이 아니기 때문에 그냥 color = "white"; 와 같이 작성해도 무관
     */
    }
    Car(String color){
        this(color,"auto",4); // 여기서 color는 지역변수 color이기 때문에 this를 붙일 이유가 없음.
    }

    Car(String color, String gear, int door){
        this.color = color;
        this.gear = gear;
        this.door = door;
    }
    
    public static void main(String [] args){
        Car c1 = new Car();
        Car c2 = new Car("black");
        Car c3 = new Car("green","manual",6);

        car("c1",c1);
        car("c2",c2);
        car("c3",c3);
    }
    static void car(String name, Car c){
        System.out.printf("%s의 정보 : 색상 : %s  기어 : %s  문 개수 : %d %n",name,c.color,c.gear,c.door);
    }
}

class Bike{
    String color;
    String gear;
    int door;

    Bike(){
        color = "blue";
        gear = "auto";
        door = 5;
    }
    Bike(Bike b){
        this(b.color,b.gear,b.door);
    }
    Bike(String color, String gear, int door){
        this.color = color;
        this.gear = gear;
        this.door = door;
    }

    public static void main(String [] args){
        Bike alton = new Bike();
        Bike sam = new Bike(alton);
        bikeprint("alton", alton);
        bikeprint("sam",sam);

        sam.color = "green";
        sam.door = 0;
        // alton과 sam 참조변수가 서로 같은 인스턴스주소를 공유하는 것이 아닌 서로 변수값만 복사한 '별개'의 인스터임을 증명함.

        bikeprint("alton", alton);
        bikeprint("sam",sam);


        
    }
    static void bikeprint(String name, Bike c){
        System.out.printf("%s의 정보 : 색상 : %s  기어 : %s  문 개수 : %d %n",name,c.color,c.gear,c.door);
}
}

class test3_5{

    static{
        System.out.println("static block");
    }

    {
        System.out.println("instance block");
    }
    test3_5(){
        System.out.println("생성자");
    }

    
    public static void main(String [] args){
        test3_5 t = new test3_5();
        test3_5 tt = new test3_5();

    }
}
/*
class test3_2{
    public static void main(String [] args){
        
    }
}
 */

 class Document{
    String name;
    static int count = 0;
    Document(){
        this("제목없음");
    }

    
    Document(String name){
        this.name = name;
        count++;
        System.out.println("문서 "+name+"이 생성됐습니다, 문서번호 :"+count);
    }
    

    public static void main(String [] args){
        Document d = new Document();
        Document d2 = new Document("java practice!");
        Document d3 = new Document();

    }
}

class loading{
    public static void main(String [] args){
        add(5L,33);
        add(33,5L);
        add(33,333);
        
    }
    static int add(int a, int b){
        return a+b;
    }
    static long add(int a, long b ){
        return a+b;
    }
    static long add(long a, int b){
        return a+b;
    }
}

