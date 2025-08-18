/*재귀시에 System.out.print 가 엄청 느려짐을 알게 됨
* bw 와 StringBuilder을 주로 에용 해야 겠음
* */
import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        sb.append((long)Math.pow(2,n)-1).append('\n');
        hanoni(n,1,2,3);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void hanoni(int n,int from,int temp,int to){
        if(n==1)
        {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        hanoni(n-1,from,to,temp);
        sb.append(from).append(' ').append(to).append('\n');
        hanoni(n-1,temp,from,to);
    }
}
