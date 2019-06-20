int fact(int n) {
   if (n <= 1)
      return 1;
   else
      return n*fact(n-1);
}

int permute(int n, int r)
{
   return fact(n) / fact(n-r);
}
