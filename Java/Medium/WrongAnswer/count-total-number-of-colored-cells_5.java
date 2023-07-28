class Solution {
    public long coloredCells(int n) {
        
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += 4 * (i - 1);
            if (i == n) {
                res += 4 * (i - 1);
            }
        }
        return res + 1;
    }
}