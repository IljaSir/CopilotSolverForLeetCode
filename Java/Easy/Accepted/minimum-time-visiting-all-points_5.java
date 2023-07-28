class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i];
            int[] point2 = points[i + 1];
            time += Math.max(Math.abs(point1[0] - point2[0]), Math.abs(point1[1] - point2[1]));
        }
        return time;
    }
}