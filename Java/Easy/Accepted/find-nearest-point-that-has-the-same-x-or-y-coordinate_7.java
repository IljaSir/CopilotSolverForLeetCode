class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int minDis = Integer.MAX_VALUE;
        int minDisIndex = -1;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if(dis < minDis) {
                    minDis = dis;
                    minDisIndex = i;
                }
            }
        }
        return minDisIndex;
    }
}