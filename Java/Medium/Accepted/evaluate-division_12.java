class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = equations.size();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            if (!map.containsKey(s1)) map.put(s1, index++);
            if (!map.containsKey(s2)) map.put(s2, index++);
        }
        double[][] graph = new double[index][index];
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            graph[map.get(s1)][map.get(s2)] = values[i];
            graph[map.get(s2)][map.get(s1)] = 1 / values[i];
        }
        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                res[i] = -1.0;
                continue;
            }
            int x = map.get(s1);
            int y = map.get(s2);
            if (x == y) {
                res[i] = 1.0;
                continue;
            }
            res[i] = dfs(graph, x, y, new boolean[index]);
        }
        return res;
    }
    private double dfs(double[][] graph, int x, int y, boolean[] visited) {
        if (graph[x][y] != 0.0) return graph[x][y];
        visited[x] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[x][i] != 0.0 && !visited[i]) {
                double res = dfs(graph, i, y, visited);
                if (res != -1.0) return graph[x][i] * res;
            }
        }
        return -1.0;
    }
}