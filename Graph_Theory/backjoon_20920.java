import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

        }
            List<String> words = new ArrayList<>(map.keySet());
            
            words.sort((w1,w2) ->
            {
                int m1 = map.get(w1);
                int m2 = map.get(w2);

                if(m1 != m2) {
                    return m2 - m1;
                }

                if(w1.length() != w2.length())
                {
                    return w2.length() - w1.length();
                }
                return w1.compareTo(w2);
            });

            for(String j : words)
            {
                bw.write(j);
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

    }
}



