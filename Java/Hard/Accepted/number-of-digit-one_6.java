class Solution {
    public int countDigitOne(int n) {
        
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            res += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return res;
    }
}