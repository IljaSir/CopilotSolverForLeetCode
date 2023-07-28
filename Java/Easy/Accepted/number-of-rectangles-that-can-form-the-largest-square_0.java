class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int len = Math.min(rectangles[i][0], rectangles[i][1]);
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