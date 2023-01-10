import java.util.*;
class Over{
    public static void main(String [] args){
        short sMin = -32768;
        short sMax = 32767;
        char ch = 65535;
        
        System.out.println((short)(sMin-1));
        System.out.println((short)(++sMax));
        System.out.println((char)(ch+10));
        System.out.println((int)(++ch));
    

        float f1 = 9.123456789f;
        double d1= 9.1234567890123456789;
        System.out.printf("%20.15f",f1);
        System.out.println(d1);
        int num1 = 1234567890;
        System.out.println((float)(num1));
        float f2 = 1234;// 리터럴 자동 형변환
        char ch1 = (char)500;
        System.out.println(ch1);
        int num2 = (int)3.0;

        byte b = (byte)1000;
        System.out.println(b);//256 4번 오버플로우시 -24됨.

        float ff = 1234;
        byte aa= 3;
        byte bb = 5;
        System.out.println(aa+bb);
        byte cc = (byte)(aa+bb);

    }
}

class Example{
    public static void main (String [] args){
        int num1 = 2_000_000;
        int num2 = 1_000_000;
        long num3 = num1*num2;
        System.out.println((long)num1*num2+""+num3);
        int num4 = 'a';
        byte num5= 13;
        byte num6 = 'a'+1;
        char num7 = 30;
        byte num8 = 127;
        byte num9 = 20;
        byte num10 = (byte)(num8 + num9);        
        long num11= 3000000000l;
        char a = 'a';
        System.out.println(a+1);
        // 에러발생 char b = a+1;
        char c= 'a'+1;

        int x = 3;
        boolean result;
        result = x>0 ? true:false;

        int [] arr = {10,20,30};
        for(int tmp : arr){
            System.out.println(tmp);
        }
    }
}

class test{
    public static void main(String [] args){

        int i = 5;

        while (--i!=0){
            System.out.println(i);
        }
        i=5;
        while (i--!=0){// 비교연산자 !=와 비교 후 i의 값이 감소됨. 따라서 1로 비교한 후 0까지도 출력. 
            System.out.println(i);
        }
    }
}

class test2{
    public static void main(String [] args){

        int i = 0, sum = 0;

        while ((sum+=++i)<=100){
            System.out.printf("i = %3d , sum = %3d%n",i,sum);
        }
    }
}

class test3{
    public static void main(String [] args){
    
        int num, sum=0;
        boolean flag = true;
        String tmp; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 , 종료하려면  0 입력>> ");
        while(flag){
            tmp = scanner.nextLine();
            num = Integer.parseInt(tmp);
            if (num != 0)
                sum+=num;
            else 
                flag=false;
        
        }
        System.out.printf("sum = %d",sum);
    }
}

class test4{
    public static void main(String [] args){
        int rannum  ,input=0 ;
        rannum = (int)(Math.random()*20)+1;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1~20사이 정수 입력");
            input = scanner.nextInt();
            if (input<rannum){
                System.out.println("더 큰 수로 해보세요");
            }
            else if (input>rannum){
                System.out.println("더 작은 수로 해보세요");
            }
        }while(rannum!=input);
        System.out.printf("정답입니다. 당신이 입력한 수는 %d입니다",input);

    }
}

class test5{
    public static void main(String []  args){
        for ( int i = 0; i<=100; i++){
            int tmp = i;
            System.out.print("i = "+i);
            do{
                if ((tmp%10%3)==0 && (tmp%10)!=0){
                    System.out.print("짝");
                }

            }while((tmp/=10)!=0);
            System.out.println("");
            /*  위 코드를 while문으로 변경시에는 10의 자리수가 3의 배수일때만 짝이 출력된다. while문에서 복합연산자가 먼저 실행되기 때문에 tmp는 
            10으로 나눈 몫(십의 자리 숫자)이 while문 안에서 실행됨. 
            */
        }
    }
}

class test6{
    public static void main(String [] args){
        for (int i=0; i<10;i++){
            if(i%3==0)continue;
            System.out.println("i = "+i);
        }
    }
}
class test7{
    public static void main(String [] args){
        Loop1 : for (int i = 2; i<=9 ; i++){
            
            for (int j = 1; j<=9; j++){
                if (j==5){
                    //break;
                    //break Loop1;
                    //continue Loop1;
                    continue;
                }
                System.out.printf("%d * %d = %d%n",i,j,i*j);
             }
        }//end of Loop1
    }
}

class test8{
    public static void main(String [] args){
        int menu = 0, num = 0;
        Scanner scanner = new Scanner(System.in);
        String input;
        outer: while(true){
            System.out.println("원하시는 메뉴를 입력하세요,1. 넓이 2. 루트 3. 로그 (종료 = 0)");
            input = scanner.nextLine();
            menu = Integer.parseInt(input);
            if (menu == 0){
                System.out.println("시스템을 종료합니다");
                break;
            }
            if (!(1<=menu && menu<=3)){ // == menu<1 && menu>3
                System.out.println("범위 내에서 입력하세요");
                continue;
            }

            for (;;){
                System.out.println("값을 입력하세요 (메뉴선택 : 0, 전체종료 : 99)");
                input = scanner.nextLine();
                num = Integer.parseInt(input);
                if (num == 0) continue outer;
                if (num == 99){
                    System.out.println("완전 종료합니다");
                    break outer;
                }
                switch(menu){

                    case 1:
                        System.out.println(num*num);
                        break;
                    case 2:
                        System.out.println(Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println(Math.log(num));
                        break;


                }


            }
        }
    }
}

class test9{
    public static void main(String [] args){
        int [] arr = new int[5];
        int num = 1;
        for (int tmp : arr){
            tmp = 10*num;
            System.out.println(tmp);
            num++;
        }
        System.out.println(arr[6]);
    }
}

class test10{
    public static void main(String [] args){
        int [] iArr = new int[0];
        int [] iBrr = new int[]{};
        int [] iCrr = {};
        //위 세문장 모두 길이가 0인 배열 생성
        char [] arr = {'a','b','c','d'};
        System.out.println(Arrays.toString(arr)); // Arrays.toString() 메서드는 import java.util.*; 를 필요로 한다.
        System.out.println(arr);

        int [] testarr = {1,2,3,4,5};
        int [] tmp = new int[testarr.length*2];
        for (int i = 0; i<testarr.length; i++){
            tmp[i]=testarr[i];
        }
        testarr=tmp;
        //tmp=testarr; 다음과 같이 코드 작성시 길이가 5인 testarr배열의 주소를 새로 생성한 길이 10의 tmp에 대입하는 것으로
        //기존의 testarr배열의 주소를 가르키는 tmp라는 참조변수 1개가 더 생긴꼴.
        for ( int arg:tmp){
            System.out.print(arg+",");
        }
        System.out.println("");
        for ( int arg:testarr){
            System.out.print(arg+",");
        }
    }
}

class test11{
    public static void main(String [] args){
        char [] arr1 = {'a','b','c','d'};
        char [] arr2 = {'1','2','3','4','5','6','7','8','9'};
        char [] arr3 = new char[arr1.length+arr2.length];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        System.out.println(arr3);
        System.arraycopy(arr1,0,arr2,3,arr1.length);
        System.out.println(arr2);
    }
}

class test12{
    public static void main(String [] args){
        int [] arr = {100,95,30,50,88,44,77};
        int sum = 0;
        for ( int i = 0; i<arr.length; i++){
            sum+= arr[i];
        }
        System.out.printf("평균 점수는 %f입니다%n\n",(float)sum/arr.length);

        int min = arr[0], max =arr[0];
        for (int i = 1; i<arr.length; i++){
            if (arr[i]>max) max=arr[i];
            else if(arr[i]<min) min=arr[i];
        }
        System.out.println("최대값은"+max+"\t 최소값은 "+min+"입니다");

    }
}

class test13{
    public static void main(String [] args){
        int [] arr = new int[10];
        int tmp, n;
        for ( int i = 0; i<arr.length; i++) arr[i]=i;

        for ( int i = 1; i<100; i++){
            n = (int)( Math.random()*arr.length); // 0~9까지의 랜덤 인덱스 번호 생성
            tmp = arr[0];
            arr[0] = arr[n];
            arr[n] = tmp;
        }
        System.out.println(Arrays.toString(arr));

    }
}

class test14{
    public static void main(String [] args){
        int [] arr = new int[45];
        int tmp, k;
        for (int i = 0; i<arr.length; i++) 
            arr[i]=i+1;
        
        for (int i = 0; i<arr.length; i++){
            k = (int)(Math.random()*45);
            tmp = arr[i];
            arr[i]=arr[k];
            arr[k]=tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

class test15{
    public static void main(String [] args){
        int [] arr = {-10,5,8,2,1,-22,-3};
        int tmp, k;
        for (int i = 0; i<arr.length; i++){
            k = (int)(Math.random()*arr.length);
            tmp = arr[i];
            arr[i]=arr[k];
            arr[k]=tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

class test16{
    public static void main(String [] args){
        int [] arr = new int[10];
        int tmp;
        boolean changed;
        for (int i = 0; i<arr.length; i++)
            System.out.print(arr[i]=(int)(Math.random()*arr.length));

        for ( int i=0; i<arr.length-1;i++){
            changed = false;
            for (int j=0; j<arr.length-1-i;j++){
                if ( arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    changed = true;
                }
            }
            if (!changed) break;
            for(int arg: arr)
                System.out.print(arg);


            System.out.println("");
           
        }
        
    }
}

class test17{
    public static void main(String [] args){
        int [] arr = new int[10];
        int [] counter = new int[10];

        for (int i =0; i<arr.length;i++){
            System.out.print(arr[i]=(int)(Math.random()*10));
        }
        System.out.println("");

        for (int i =0; i<arr.length;i++){
            counter[arr[i]]++;
        }
        
        for (int i =0; i<arr.length;i++){
            System.out.printf("%d의 개수 : %d%n",i,counter[i]);
        }
    }
}
/*
class test100{
    public static void main(String [] args){

    }
}
class test100{
    public static void main(String [] args){

    }
}
 */