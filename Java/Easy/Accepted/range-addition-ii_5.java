class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        
        int min1 = m;
        int min2 = n;
        for (int[] op : ops) {
            min1 = Math.min(min1, op[0]);
            min2 = Math.min(min2, op[1]);
        }
        return min1 * min2;
    }
}