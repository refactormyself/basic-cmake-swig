/* File : example.c */
 
#include <stdio.h>
#include <time.h>
#include "example.h"

 double My_variable = 3.0;

 int square(int n){
	return multiply(n, n);
 }
 
 int permute(int n, int r) {
     int num = fact(n); printf("\n==> %d", num);
     int denum = fact(n-r);printf("\n==> %d", denum);
     int rem = my_mod(num, denum);printf("\n==> %d", rem);

     if(rem>0){ printf("\n there is a left over here ... It is %d\n", rem);}
     return num/denum;
 }

char *get_time()
 {
     time_t ltime;
     time(&ltime);
     return ctime(&ltime);
 }

int main(){
	printf("\n The square of 99 is %d", square(99));
	printf("\n Time now is -  %s", get_time());
	printf("\n Permute 9 with 2 gives: %d\n\n", permute(9,2));
	
	return 0;
}
