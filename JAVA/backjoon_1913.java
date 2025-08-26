import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int [][] a = new int[N][N];

        int r = N / 2;
        int c = N /2;

        int val= 1;
        a[r][c] = val;

        int x = r+1;
        int y = c+1;

        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        int dir=0;

        int step = 1;
        int target = N*N;

        while(val < target){
            for(int repeat = 0; repeat<2 && val < target ; repeat++){
                for(int length = 0; length < step && val < target ; length++ ){
                    r += dirs[dir][0];
                    c += dirs[dir][1];

                    val += 1;
                    a[r][c] = val;
                    if(val == M)
                    {
                        x = r + 1;
                        y = c + 1;
                    }
                }
                dir = (dir+1) % 4;
            }
            step++;
        }

        for(int i=0; i< N; i++)
        {
            for(int j = 0; j< N; j++)
            {
                if(j>0) sb.append(" ");
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }
        sb.append(x).append(' ').append(y);
        System.out.print(sb.toString());
    }
}
