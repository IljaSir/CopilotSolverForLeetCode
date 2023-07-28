class Solution {
    public int countGoodNumbers(long n) {
        
        long even = n / 2;
        long odd = (n + 1) / 2;
        long res = 1;
        res = res * pow(5, even);
        res = res % 1000000007;
        res = res * pow(4, odd);
        res = res % 1000000007;
        return (int) res;
    }
    
    private long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                res = res * x;
                res = res % 1000000007;
            }
            x = x * x;
            x = x % 1000000007;
            y = y / 2;
        }
        return res;
    }
}