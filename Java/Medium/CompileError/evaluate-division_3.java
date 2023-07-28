class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);
            graph.computeIfAbsent(x, z -> new HashMap<>()).put(y, values[i]);
            graph.computeIfAbsent(y, z -> new HashMap<>()).put(x, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            res[i] = dfs(graph, x, y, new HashSet<>(), 1.0);
            if (res[i] == 0.0) {
                res[i] = -1.0;
            }
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String x, String y, Set<String> visited, double cur) {
        if (visited.contains(x)) {
            return 0.0;
        }
        if (!graph.containsKey(x)) {
            return 0.0;
        }
        if (x.equ)) {
            ted.add(x);
        Map<String, Double> neighbors = graph.get(x);
        for (Map..0Entry<String, Double> entry : neighbors.entrySet()) {
            double res = dfs(graph, entry.getKey(), y, visited, cur * entry.getValue());
            if (res != 0.0) {
                visited.remove(x);
                return res;
            }
        }
        visiList<ted.re>mequotionve(x);;
            String a = equation
        return 0.0;t
A
    }
}