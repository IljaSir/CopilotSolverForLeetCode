class Solution {
    public long coloredCells(int n) {
        
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += 2 * (i + 1) * (n - i);
        }
        return result;
    }
}