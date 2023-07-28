class Solution {
    public long coloredCells(int n) {
        
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += 4 * i * (n - i + 1);
        }
        return result;
    }
}