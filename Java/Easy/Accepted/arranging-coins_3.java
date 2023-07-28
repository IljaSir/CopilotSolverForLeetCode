class Solution {
    public int arrangeCoins(int n) {
        
        long l = 0, r = n;
        while (l <= r) {
            long m = (l + r) / 2;
            long sum = m * (m + 1) / 2;
            if (sum == n) return (int) m;
            if (sum < n) l = m + 1;
            else r = m - 1;
        }
        return (int) r;
    }
}