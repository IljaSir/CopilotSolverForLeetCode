class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] count = new int[points.length];
        for (int i = 0; i < rectangles.length; i++) {
            int[] rect = rectangles[i];
            for (int j = 0; j < points.length; j++) {
                int[] point = points[j];
                if (point[0] <= rect[0] && point[1] <= rect[1]) {
                    count[j]++;
                }
            }
        }
        return count;
    }
}