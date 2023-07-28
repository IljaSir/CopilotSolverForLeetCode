class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
.0

        int n = equations.size();
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            ans[i] = dfs(graph, a, b, new HashSet<>(), 1);
        }
        return ans;
    }
    private double dfs(Map<String, Map<String, Double>> graph, String a, String b, Set<String> visited, double cur) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1;
        }
        if (a.equals(b)) {
            return cur;
        }
        visited.add(a);
        Map<String, Double> next = graph.get(a);
        for (String nextA : next.keySet()) {
            if (visited.contains(nextA)) {
                continue;
            }
            double ans = dfs(graph, nextA, b, visited, cur * next.get(nextA));
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }
}