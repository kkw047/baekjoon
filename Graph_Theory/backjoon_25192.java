import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();

        int count = 0;

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < a; i++) {
            String line = sc.nextLine();
            if(line.equals("ENTER")){
                set.clear();
            }
            else {
                if(!set.contains(line)){
                    count++;
                    set.add(line);
                }
            }

        }

        System.out.println(count);
        sc.close();
    }
}
