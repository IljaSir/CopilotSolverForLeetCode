class Solution {
    public long coloredCells(int n) {
        
        long result = 0;
        long count = 0;
        for (int i = 1; i <= n; i++) {
            long tmp = 2 * i - 1;
            if (i % 2 == 0) {
                count += tmp;
            } else {
                count += tmp + 1;
            }
            result += count;
        }
        return result;
    }
}