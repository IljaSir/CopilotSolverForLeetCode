class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            for (int[] rect : rectangles) {
                if (x <= rect[0] && y <= rect[1]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}