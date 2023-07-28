class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x1 = point[0];
            int y1 = point[1];
            if (x == x1 || y == y1) {
                int distance = Math.abs(x - x1) + Math.abs(y - y1);
                if (distance < min) {
                    min = distance;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}