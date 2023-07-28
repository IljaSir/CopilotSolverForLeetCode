class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                if (points[i][0] <= rectangles[j][0] && points[i][1] <= rectangles[j][1]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}