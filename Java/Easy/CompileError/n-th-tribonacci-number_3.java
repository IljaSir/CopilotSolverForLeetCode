class Solution {
    public int tribonacci(int n) {
        
        if(n = 0) {
           return 0;
        }
        if(n ==  || n == 2) {
            return 1;
        }
        int a = 0
        int b = 1;
        int c = 1;
        int d = 0;
        rer(int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        retutn d;
    }
}