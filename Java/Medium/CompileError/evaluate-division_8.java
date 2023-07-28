class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<Sring, List<Double>> weight = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfbsent(u, new ArrayList<>(
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            weight.putIfAbsent(u, new ArrayList<>());
            weight.putIfAbsent(v, new ArrayList<>());
            weight.get(u).add(values[i]);
            weight.get(v).add(1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(graph, weight, u, v, new HashSet<String>(), 1.0);
            }
        }
        return res;
    }
    private double dfs(Map<String, List<String>> graph, Map<String, List<Double>> weight, String u, String v, Set<String> visited, double cur) {
        if (u.equals(v)) {
            return cur;
        }
        visited.add(u);
        List<String> neighbors = graph.get(u);
        List<Double> w = weight.get(u);
        for (int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            if (!visited.contains(neighbor)) {
                double res = dfs(graph, weight, neighbor, v, visited, cur * w.get(i));
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }
}