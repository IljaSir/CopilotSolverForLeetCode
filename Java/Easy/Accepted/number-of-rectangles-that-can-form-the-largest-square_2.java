class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int maxLen = 0;
        int count = 0;
        for (int[] r : rectangles) {
            int len = Math.min(r[0], r[1]);
            if (len > maxLen) {
                maxLen = len;
                count = 1;
            } else if (len == maxLen) {
                count++;
            }
        }
        return count;
    }
}