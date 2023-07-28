class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] result = new int[points.length];
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (points[j][0] <= rectangles[i][0] && points[j][1] <= rectangles[i][1]) {
                    result[j]++;
                }
            }
        }
        return result;
    }
}