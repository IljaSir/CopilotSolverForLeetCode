class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = equations.size();
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equaions.get(i).get(1);
            graph.putIfbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                res[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(a, b, graph, visited);
            }
        }
        return res;
    }
    
    private double dfs(String a, String b, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (a.equals(b)) {
            return 1.0;
        }
        visited.add(a);
        Map<String, Double> neighbors = graph.get(a);
        for (String neighbor : neighbors.keySet()) {
            if (visited.contains(neighbor)) {
                continue;
            }
            double res = dfs(neighbor, b, graph, visited);
            if (res != -1.0) {
                return res * neighbors.get(neighbor);
            }
        }
        return -1.0;
    }
}