class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int max = 0;
        int count = 0;
        for (int[] r : rectangles) {
            int min = Math.min(r[0], r[1]);
            if (min > max) {
                max = min;
                count = 1;
            } else if (min == max) {
                count++;
            }
        }
        return count;
    }
}