class Solution {
    public int integerReplacement(int n) {
        
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                n -= 1;
            } else {
                n += 1;
            }
            res++;
        }
        return res;
    }
}