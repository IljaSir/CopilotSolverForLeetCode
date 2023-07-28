class Solution {
    public int countGoodNumbers(long n) {
        
        long ans = 1;
        long mod = (long) (1e9 + 7);
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * 5 % mod;
            }
            ans = ans * ans % mod;
            n /= 2;
        }
        return (int) ans;
    }
}