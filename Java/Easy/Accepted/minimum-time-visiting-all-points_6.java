class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int total = 0;
        int prevX = points[0][0];
        int prevY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int xDiff = Math.abs(x - prevX);
            int yDiff = Math.abs(y - prevY);
            total += Math.max(xDiff, yDiff);
            prevX = x;
            prevY = y;
        }
        return total;
    }
}