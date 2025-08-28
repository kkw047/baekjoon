import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        dfs(0,1);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0; i<M;i++)
            {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N;i++)
        {
            result[depth] = i;
            dfs(depth+1, i);
        }

    }
}
