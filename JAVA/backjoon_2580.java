import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int r, int c){
        if(finish){ return;}

        if(c==9)
        {
            dfs(r+1,0);
            return;
        }

        if(r==9)
        {
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            finish = true;
            return;
        }

        if(map[r][c]!=0)
        {
            dfs(r,c+1);
            return;
        }

        boolean[] used = new boolean[10];
        for(int i = 0; i < 9; i++)
        {
            int v = map[r][i];
            if(v != 0){used[v]= true;}
        }

        for(int j = 0; j < 9; j++){
            int v = map[j][c];
            if(v!=0){used[v]= true;}
        }

        for(int i = 1; i<= 9; i++)
        {
            if(!used[i] && check_box(r,c,i)){
                map[r][c] = i;
                dfs(r,c+1);
                if(finish) return;

                map[r][c] = 0;
            }
        }
    }

    static boolean check_box(int r, int c,int num){
        int box_r = (r/3)*3;
        int box_c = (c/3)*3;

        for(int i = box_r; i < box_r+3; i++){
            for(int j = box_c; j < box_c+3; j++){
                if(map[i][j]==num) return false;
            }
        }
        return true;
    }
}
