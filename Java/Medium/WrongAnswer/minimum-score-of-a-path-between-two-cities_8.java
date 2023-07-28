class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] distance = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<roads.length; i++) {
            distance[roads[i][0]][roads[i][1]] = Math.min(distance[roads[i][0]][roads[i][1]], roads[i][2]);
            distance[roads[i][1]][roads[i][0]] = Math.min(distance[roads[i][1]][roads[i][0]], roads[i][2]);
        }
        for(int i=1; i<n+1; i++) {
            distance[i][i] = 0;
        }
        for(int k=1; k<n+1; k++) {
            for(int i=1; i<n+1; i++) {
                for(int j=1; j<n+1; j++) {
                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], Math.max(distance[i][k], distance[k][j]));
                    }
                }
            }
        }
        return distance[1][n];
    }
}