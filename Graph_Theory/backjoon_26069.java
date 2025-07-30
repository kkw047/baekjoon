import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> dancer = new HashSet<>();
        dancer.add("ChongChong");

        for(int i=0; i<n; i++){
            String[] name = sc.nextLine().split(" ");
            String me = name[0];
            String friend = name[1];

            if(dancer.contains(me) || dancer.contains(friend)){
                dancer.add(me);
                dancer.add(friend);
            }
        }

        System.out.println(dancer.size());

    }
}
