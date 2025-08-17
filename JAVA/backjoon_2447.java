import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], ' ');

        star(board,0,0,n);

        StringBuilder sb = new StringBuilder(n*(n+1));
        for(int i=0; i<n; i++){
            sb.append(board[i]).append('\n');
        }
        System.out.println(sb);

    }

    public static void star(char[][] board, int a, int b, int n)
    {
        if(n==3)
        {
            for(int i = 0; i < 3; i++)
            {
                for( int j = 0; j < 3; j++)
                {
                    if(i==1 && j == 1) continue;

                    board[a + i][b+j] = '*';
                }
            }
            return;
        }

        int size = n/3;
        for(int i =0; i< 3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i==1 && j == 1) continue;
                star(board,a+i*size,b+j*size,size); // a + 1/3 2/3 3/3 으로 각각 나눠서
            }
        }

    }

}
