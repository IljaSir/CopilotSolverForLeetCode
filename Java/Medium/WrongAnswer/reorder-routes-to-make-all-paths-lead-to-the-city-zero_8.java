class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int[] visited = new int[n];
        int[][] graph = new int[n][n];
        int count = 0;
        for (int[] c : connections) {
            graph[c[0]][c[1]] = 1;
            graph[c[1]][c[0]] = -1;
        }
        dfs(graph, visited, 0);
        for (int v : visited) {
            if (v == 1) {
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] graph, int[] visited, int city) {
        visited[city] = 1;
        for (int i = 0; i < graph[city].length; i++) {
            if (graph[city][i] == 1 && visited[i] == 0) {
                dfs(graph, visited, i);
            }
            if (graph[city][i] == -1 && visited[i] == 0) {
                dfs(graph, visited, i);
                graph[city][i] = 1;
                graph[i][city] = 0;
            }
        }
    }
}