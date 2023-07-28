class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        int max = 0;
        int prev = bottom - 1;
        for (int n : special) {
            max = Math.max(max, n - prev - 1);
            prev = n;
        }
        return Math.max(max, top - prev);
    }
}