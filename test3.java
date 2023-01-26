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