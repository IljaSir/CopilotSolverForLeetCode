class Solution {
    public double largestTriangleArea(int[][] points) {
        
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea;
    }
}