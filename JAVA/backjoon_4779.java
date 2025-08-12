import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);
            int size = (int)Math.pow(3,n);

            char[] arr = new char[size];
            Arrays.fill(arr,'-');

            cator(arr,0,size);
            System.out.println(arr);
        }
    }

    public static void cator(char[] arr, int start, int length){ // 배열, 시작, 길이
        if(length == 1) return;

        int three = length/3;
        for(int i = start + three; i< start + 2*three; i++){ // 1/3 시작 2/3 까지
            arr[i] = ' ';
        }

        cator(arr,start,three);  // 0 부터 1/3  -> 왼쪽
        cator(arr,start+ 2*three,three);  // 2/3 부터 3/3 까지 오른쪽
    }
}
