class Solution {
    public long coloredCells(int n) {
        
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += 2 * (n - i) + 1;
        }
        return ans;
    }
}