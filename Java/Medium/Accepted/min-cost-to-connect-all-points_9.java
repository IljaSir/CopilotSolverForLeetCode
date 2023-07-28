class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    index = j;
                }
            }
            visited[index] = true;
            result += min;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    dist[j] = Math.min(dist[j], Math.abs(points[j][0] - points[index][0]) + Math.abs(points[j][1] - points[index][1]));
                }
            }
        }
        return result;
    }
}