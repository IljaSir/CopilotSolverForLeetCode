class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[] cost = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int min = Integer.MAX_VALUE, minIdx = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && cost[j] < min) {
                    min = cost[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            res += min;
            for (int j = 0; j < n; ++j) {
                if (!visited[j]) {
                    cost[j] = Math.min(cost[j], Math.abs(points[j][0] - points[minIdx][0]) + Math.abs(points[j][1] - points[minIdx][1]));
                }
            }
        }
        return res;
    }
}