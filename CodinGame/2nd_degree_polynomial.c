#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

 void print_num(double v)
 {
    double r = round(v*100.0)/100.0;

    char buf[32];
    sprintf(buf,"%.2f",r);
    int len = strlen(buf);

    while(len>0 && buf[len-1] == '0'){
        buf[--len] = '\0';
    }
    if(len>0 && buf[len-1] == '.'){
        buf[--len] = '\0';
    }

    printf("%s",buf);
 }


int main()
{
    float a;
    float b;
    float c;
    scanf("%f%f%f", &a, &b, &c);
    //a^2x + bx + c
    // Write an answer using printf(). DON'T FORGET THE TRAILING \n
    // To debug: fprintf(stderr, "Debug messages...\n");

    if(fabs(a)<1e-9)
    {
        if(fabs(b)<1e-9)
        { // a=0 b=0  c = 0 or f
            printf("("); print_num(0.0); printf(","); print_num(c); printf(")\n");
        }
        else
        { // a=0 b=f c = f
            float result = -c/b;
            if(result <= 0.0f){
                printf("("); print_num(result); printf(","); print_num(0.0); printf("),");
                printf("("); print_num(0.0); printf(","); print_num(c);  printf(")\n");
            }else
            {
                 printf("("); print_num(0.0); printf(","); print_num(c);  printf("),");
                printf("("); print_num(result);  printf(","); print_num(0.0); printf(")\n");
            }
        }
        return 0;
    }

    float delta;
    delta = b*b - 4*(a*c);
    if(delta<0)
    {
        printf("("); print_num(0.0); printf(","); print_num(c); printf(")");
    }
    else if(fabs(delta)<1e-9)
    {
        float x1 = (-b)/(2*a);
        if(x1 > 0)
        {
            printf("("); print_num(0.0); printf(","); print_num(c); printf("),");
            printf("("); print_num(x1); printf(","); print_num(0.0); printf(")");
        }
        else
        {
            printf("("); print_num(x1); printf(","); print_num(0.0); printf("),");
            printf("("); print_num(0.0); printf(","); print_num(c); printf(")");
        }
    }
    else if(delta>0)
    {
        float s = sqrt(delta);
        float x1 = (-b-s)/(2*a);
        float x2 = (-b+s)/(2*a);

        if (x1 > x2) { 
            float swap=x1; 
            x1=x2; 
            x2=swap; 
        } // 항상 x1<=x2

        if (x2 <= 0.0f) {
            printf("("); print_num(x1); printf(","); print_num(0.0); printf("),");
            printf("("); print_num(x2); printf(","); print_num(0.0); printf("),");
            printf("("); print_num(0.0); printf(","); print_num(c); printf(")");
        } else if (x1 >= 0.0f) {
            printf("("); print_num(0.0); printf(","); print_num(c); printf("),");
            printf("("); print_num(x1); printf(","); print_num(0.0); printf("),");
            printf("("); print_num(x2); printf(","); print_num(0.0); printf(")");

            
        } else {
            printf("("); print_num(x1); printf(","); print_num(0.0); printf("),");
            printf("("); print_num(0.0); printf(","); print_num(c); printf("),");
            printf("("); print_num(x2); printf(","); print_num(0.0); printf(")");            
        }
    }


    return 0;
}
