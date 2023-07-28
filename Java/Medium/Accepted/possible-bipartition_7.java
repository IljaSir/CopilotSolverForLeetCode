class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[] group = new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(List<Integer>[] graph, int[] group, int cur, int g) {
        if (group[cur] != 0) {
            return group[cur] == g;
        }
        group[cur] = g;
        for (int next : graph[cur]) {
            if (!dfs(graph, group, next, -g)) {
                return false;
            }
        }
        return true;
    }
}