class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int[] visited = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(i, isConnected, visited);
            }
        }
        return res;
    }
    
    public void dfs(int i, int[][] isConnected, int[] visited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(j, isConnected, visited);
            }
        }
    }
}