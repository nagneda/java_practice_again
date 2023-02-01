import java.util.*;

class test2_1 {
    public static void main(String [] args){
        char [] hex = {'3','2','8','5'}; // 16진수로 변경해도 가능
        String [] binary = {"0000","0001","0010","0011",
                            "0100","0101","0110","0111",
                            "1000","1001","1010","1011",
                            "1100","1101","1110","1111"};

        String result = "";

        for (int i = 0; i<hex.length;i++){
            if('0'<=hex[i]&&hex[i]<='9')
                result += binary[hex[i]-'0'];
            else
                result += binary[hex[i]-'A'+10];
                
        }
        System.out.println(result);
    }
}


class test2_2 {
    public static void main(String [] args){
        String str = "abcde";
        System.out.println(str.charAt(2));// 인덱싱
        System.out.println(str.length()); // 문자열 길이
        System.out.println(str.substring(1,3));//뒤의 인덱스는 슬라이싱에 포함되지 않음
        System.out.println(str.equals("abcde")); // 괄호안의 문자열과 동일한지 / 대소문자 구분하지 않는 비교 메서드는 따로 있음
        System.out.println(str.toCharArray()); // char 타입의 배열화
        
        
    }
}

class test2_3 {
    public static void main(String [] args){
        String src = "ABCD";
        char [] arr = {'a','b','c','d'};
        for (int i = 0; i<src.length() ; i++){
            System.out.println("src["+i+"] ="+src.charAt(i)); 
        }

        System.out.println(Arrays.toString(src.toCharArray()));
        System.out.println(Arrays.toString(arr)+"\t"+new String(arr));

        String [] arr1 = {"abc","def","ghi"};
        System.out.println(arr1[1].charAt(2));

    }
}

class test2_4 {
    public static void main(String [] args){
        int [][] arr = {
            {1,2,3},
            {5,1,2,3},
            {4,3,2}
        };

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}

class test2_5 {
    public static void main(String [] args){

        int [][] arr = {
            {100,20,35},
            {232,231,11},
            {33,221,552}
        };
        int sum=0;

        for (int i=0; i<arr.length;i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.printf("arr[%d][%d] = %d%n",i,j,arr[i][j]);
                sum+=arr[i][j];
            }
        }
        System.out.println(sum);
        sum=0;
        for (int[] arr1 : arr){
            for(int arr2: arr1){
                sum += arr2;
            }
        }// 향상된 for문을 사용시 인덱스로 접근하지 못하기 때문에 배열 요소의 값을 변경할 수는 없음. 간소화돼서 가독성은 좋음.
        System.out.println(sum);
    }
}

class test2_6 {
    public static void main(String [] args){
        int i = 1;
        System.out.println((char)(i+'0'));
    }
    char chr = 'a';
    int x=0 ;
    int y= (int)chr;
}

class test2_7 {
    public static void main(String [] args){
        final byte TEN = 10;
        char [][] columnlow = new char[TEN][TEN]; // 단순히 행과 열의 번호를 표시하는 용도면 정수형으로 선언해도 되자만 O,X를 추가하기 위함.
        byte [][] shipboard = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
        };
        int x=0, y=0;

        Scanner scanner = new Scanner(System.in);
        for ( int i =1; i<TEN; i++){
            columnlow[0][i]=columnlow[i][0]=(char)(i-'0');
        }
        System.out.println("행과 열을 입력하세요 (종료 : 00)");
        for(;;){
            String input = scanner.nextLine();
            if(input.length()!=2){
                System.out.println("재입력하세요");
                continue;
            }
            else{//아래와 같이 하지 않으면 에러가 발생. 예외처리를 하던가 해야하는데 사용자가 예를 들어 숫자가 아닌 문자를 입력했을 경우 charAt()로 인덱싱값을
                //저장하기 위해서는 타입을 알아야하고 결국은 타입을 검사해야할 수 밖에 없음. 책의 예제는 글자를 입력했을 경우는 에러가 발생할 것.
                if(('0'<=input.charAt(0)&&input.charAt(0)<='9')&&('0'<=input.charAt(1)&&input.charAt(1)<='9')){ 
                    x= input.charAt(0)-'0';
                    y= input.charAt(1)-'0';
                    if(x==0 && y==0){
                        System.out.println("종료합니다");
                        break;
                    }
                    }
                
                else{
                    System.out.println(" 숫자를 입력하세요");
                    continue;
                }
            }
            columnlow[x][y]=shipboard[x-1][y-1]==1? 'O':'X';
            for(int i = 0; i<TEN; i++){
                System.out.println(columnlow[i]);
            }
            System.out.println("행과 열을 입력하세요 (종료 : 00)");
        }
    }
}



class test2_8 {
    public static void main(String [] args){
        final int SIZE = 5;
        int [][] board = new int[SIZE][7];
        int x, y, num=0;
        Scanner scanner = new Scanner(System.in);

        for( int i=0; i<board.length;i++)
            for( int j=0; j<board[i].length;j++)
                board[i][j] = (i*board[i].length)+j+1;


        
        for( int i=0; i<board.length;i++)
            for( int j=0; j<board[i].length;j++){//책속의 예제와 다르게 상수를 쓰지 않고 행과 열이 가변적이라면(물론 각 배열별 열의 길이는 같아야함)
                //배열의 length로 접근하는 것이 조금 더 가용성이 높다.
                x = (int)(Math.random()*board.length);
                y = (int)(Math.random()*board[i].length);
                int tmp = board[i][j];
                board[i][j]=board[x][y];
                board[x][y]= tmp;
            }
        //초기화 및 셔플 확인
        for( int i =0; i<board.length;i++)
            System.out.println(Arrays.toString(board[i])); // char배열이 아니라서 Arrays.toString없이는 객체 주소가 출력이 됨.


        do{
            for ( int [] arr1 : board){
                for ( int arr2 : arr1){
                    System.out.printf("%3d",arr2);
                }System.out.println("");
            }
            
            System.out.println("빙고입니다. 숫자를 입력하세요. (종료:0)");
            String input = scanner.nextLine();
            num = Integer.parseInt(input);

            outer: for( int i=0; i<board.length;i++){
                for( int j=0; j<board[i].length;j++){
                   if(board[i][j]==num){
                       board[i][j]=0;
                       break outer;
                   }
                }
            }
                    

        }while(num!=0);
    }
}

class test2_9 {
    public static void main(String [] args){
        int [][] m1 = {
            {1,2,3},
            {4,5,6}
        };

        int [][] m2 = {
            {1,2},
            {3,4},
            {5,6}
        };
        int sum = 0, sum2=0;

        for (int i = 0; i<m1.length; i++){
            for (int j = 0; j<m2[0].length;j++){
                for ( int k = 0; k<m2.length; k++ ){
                    sum += m1[i][k]*m2[k][j];
                   
                } System.out.println(sum);
                sum=0;
            }
        }
    
    }
}

class test2_10 {
    public static void main(String [] args){
        String [][] arr = {
            {"컴퓨터","computer"},
            {"의자","chair"},
            {"사과","apple"}
        };
        Scanner scanner = new Scanner(System.in);
        
        for(int i =0; i<arr.length; i++){
            System.out.printf("%s의 뜻은?",arr[i][1]);
            String input = scanner.nextLine();
            if (input.equals(arr[i][0]))//input==arr[i][0] 이것과는 다르다  , String은 클래스로서 참조변수기 때문에 문자열과 참조변수 주소를 비교하는 꼴.
                System.out.println("정답입니다");
                
            else System.out.println("오답입니다");
        }
    }
}
/*
class test1 {
    public static void main(String [] args){

    }
}
class test1 {
    public static void main(String [] args){

    }
}

 */