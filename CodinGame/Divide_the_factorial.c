#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <limits.h>

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
//  A^x  B!    AB  x -> B! % A^x =값이 나오는 최대 x값 
// A B 주어짐
    // 14!에 7^x 이 몇 들어가 있냐
    // 2번이다 
    // 왜? 14 13 12 11 10 9 8 7 6 5 4 3 2 1
    // 따라서 14에 7 그냥 7 즉 x 는 2이다. 최대공약수?최소공배수?
    // 14/7=2
    // 12 10
    // 10!에 12가 몇번 들어가있냐
    // 12 -> 2^2 x 3 
    // 10 9 8 7 6 5 4 3 2 1 
    // 1 3 1 2 1 -> 8 0> 2^2 0> 4
    // 3? 2 1 1 -> 4번 4-> 즉 x = 4
    // 내가 구해야 할것은 소인수분해 후 공약수를 찾고 그중 최소인거를 x로 잡는다.

long long factorial_num(long long B, long long p)
{
    long long cnt = 0;
    while(B>0)
    {
        B /= p;
        cnt +=  B;
    }
    return cnt;
}

int main()
{
    long long A;
    long long B;
    scanf("%lld%lld", &A, &B);

    // Write an answer using printf(). DON'T FORGET THE TRAILING \n
    // To debug: fprintf(stderr, "Debug messages...\n");
    long long a = A;
    long long answer = LLONG_MAX; // answer은 Xp의 최소값이여야 하므로 ll의 가장 큰값을 부여


    for(long long i = 2; i*i<= a; i++) // why? i*i 왜 루트 를 씌우면은 그 값은 a를 넘을수가 없다 if a = 10 4*4 = 16 즉 10에는 4라는 인수가 없아 5? 2에 포함 2x5 2를 알면 5를 아니깐
    { 
        if(a%i == 0)
        {
            int e =0;
            while(a%i == 0)
            {
                a /= i;
                e++;
            }

            // A ^ e

            long long v = factorial_num(B,i); // B에 i가 몇번 들가있냐 V = B!를 소인수 분해 하여 B에 i가 몇번 들었는지 확인
            long long Xp = v/e; // V는 몇번인지 이고 우리가 원하는건 A가 들어가 있는거 
                                // 따라서 v에 e를 나눠서 몇번 들었는지 차즌ㄴ게 xp
                                // ex) 12 10! 이면 2^2*3 인데 이떄 v = factorial_num(10,2) 8번 v = 8이고 xp 는 2^2이 몇개인지 이므로 
                                // e를 나눠주어서 8/2 해서 4번이다.

           if(answer>Xp)
           {
            answer = Xp;
           }

        }
    }

    if(a>1)
    {
        long long v = factorial_num(B,a);
        long long Xp = v;
        if(answer>Xp)
           {
            answer = Xp;
           }    
    }
    
    if(answer == LLONG_MAX){answer = 1;} // 답이 1일떄를 초기화 

    printf("%lld\n", answer);
    return 0;

}
