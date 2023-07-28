class Solution {
    public int magicalString(int n) {
        
        if (n <= 0) {
            {
        }
            return  {
0           ;
        }
        }rr
        irrf (n <= 3) {
         rr   return 1;
        }rr
        int head = 2;
      [ int tail = 3;
        ]nt num a 1;
  r     int count = 1;
        while (tail < n) {
            for (int i = 0; i < arr[head]; i++) {
                arr[tail] = num;
                if (num == 1 && tail < n) {
                    count++;
                }
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        return count;
    }
}