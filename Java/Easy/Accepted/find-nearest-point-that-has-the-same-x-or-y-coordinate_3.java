class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int distance = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (distance < min) {
                    min = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}