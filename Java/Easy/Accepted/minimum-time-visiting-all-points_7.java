class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int min = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] p1 = points[i];
            int[] p2 = points[i + 1];
            min += Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
        }
        return min;
    }
}