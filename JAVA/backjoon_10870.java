import java.util.*;

public class Main {
    public static long fibo(int n) {
        if(n == 0)
        {
            return 0;
        }else if(n == 1)
        {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((long)fibo(n));
    }
}



/*
import java.io.*;

public class Main {

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());  // long으로 입력 받기
        System.out.println(factorial(n));
    }
}

 */
