import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n+1]; // 1부터니깐 1 추가
        dfs(0);
        System.out.println(sb.toString());

    }

    public static void dfs(int depth) {
        if(depth == m){
            for(int i=0; i<m; i++)
            {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i <= n; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth+1);
            visited[i] = false;
        }


    }
}
