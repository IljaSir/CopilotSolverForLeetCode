class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        
        int max = 0;
        int count = 0;
        for (int[] r : rectangles) {
            int s = Math.min(r[0], r[1]);
            if (s > max) {
                max = s;
                count = 1;
            } else if (s == max) {
                count++;
            }
        }
        return count;
    }
}