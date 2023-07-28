class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int[][] graph = new int[n][n];
        for (int[] c : connections) {
            graph[c[0]][c[1]] = 1;
            graph[c[1]][c[0]] = -1;
        }
        return dfs(graph, 0, new boolean[n]);
    }
    public int dfs(int[][] graph, int node, boolean[] visited) {
        visited[node] = true;
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                count += 1 + dfs(graph, i, visited);
            } else if (graph[node][i] == -1 && !visited[i]) {
                count += dfs(graph, i, visited);
            }
        }
        return count;
    }
}