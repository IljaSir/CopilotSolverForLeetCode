class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            for (int j = 0; j < rectangles.length; j++) {
                if (x <= rectangles[j][0] && y <= rectangles[j][1]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}