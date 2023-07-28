class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());
            graph.get(x).put(y, values[i]);
            graph.get(y).put(x, 1.0 / values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            ans[i] = dfs(x, y, 1.0, graph, new HashSet<>());
        }
        return ans;
    }

    private double dfs(String x, String y, double val, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(x) || !graph.containsKey(y)) {
            return -1.0;
        }
        if (x.equals(y)) {
            return val;
        }
        visited.add(x);
        for (String next : graph.get(x).keySet()) {
            if (!visited.contains(next)) {
                double ans = dfs(next, y, val * graph.get(x).get(next), graph, visited);
                if (ans != -1.0) {
                1.0;
    }
}