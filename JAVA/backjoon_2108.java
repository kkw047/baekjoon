import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] num = new int[n];
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            sum += num[i];

            map.put(num[i],map.getOrDefault(num[i],0)+1);
        }

        System.out.println(Math.round((double)sum/n));

        Arrays.sort(num);
        System.out.println(num[n/2]);

        int max = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> chebin : map.entrySet()){
            if(chebin.getValue() == max){
                list.add(chebin.getKey());
            }
        }

        Collections.sort(list);
        if(list.size() > 1)
        {
            System.out.println(list.get(1));
        }
        else {

            System.out.println(list.get(0));
        }

        System.out.println(Math.abs(num[0] - num[n-1]));
        sc.close();
    }
}
