class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }
        for(int[] time: times) {
            map[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0; j < n; j++) {
                if(!visited[j] && dist[j] < min) {
                    minIndex = j;
                    min = dist[j];
                }
            }
            visited[minIndex] = true;
            for(int j = 0; j < n; j++) {
                if(map[minIndex][j] != -1 && dist[minIndex] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(dist[j], map[minIndex][j] + dist[minIndex]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}