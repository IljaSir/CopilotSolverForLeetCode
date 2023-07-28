class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int maxLen = 0;
        int count = 0;
        for (int[] r : rectangles) {
            int min = Math.min(r[0], r[1]);
            if (min > maxLen) {
                maxLen = min;
                count = 1;
            } else if (min == maxLen) {
                count++;
            }
        }
        return count;
    }
}