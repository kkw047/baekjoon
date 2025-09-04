import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] Colofrow;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Colofrow = new int[N];
        dfs(0);
        System.out.print(count);
    }

    public static void dfs(int row){
        if(row == N)
        {
            count++;
            return;
        }
        for(int col = 0; col < N; col++)
        {
            if(check(row, col))
            {
                Colofrow[row] = col;
                dfs(row + 1);
            }
        }
    }

    public static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            int used = Colofrow[i];
            if(used == col) return false;
            if(Math.abs(row-i) == Math.abs(col - used)) return false;
        }
        return true;
    }

}
