import java.util.*;

public class Main{
    static int count = 0;
    public static int recursion(String s, int l, int r){
        count = count+1 ;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++){
            count = 0;
            String s = sc.nextLine();
            System.out.println(isPalindrome(s) +" "+ count);
        }

    }
}
