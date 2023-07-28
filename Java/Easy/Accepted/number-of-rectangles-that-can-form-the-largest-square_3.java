class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int max = 0;
        for (int i = 0; i < rectangles.length; i++) {
            max = Math.max(max, Math.min(rectangles[i][0], rectangles[i][1]));
        }
        int count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            if (Math.min(rectangles[i][0], rectangles[i][1]) == max) {
                count++;
            }
        }
        return count;
    }
}