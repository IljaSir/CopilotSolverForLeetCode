class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (dist < min) {
                    min = dist;
                    index = i;
                }
            }
        }
        return index;
    }
}