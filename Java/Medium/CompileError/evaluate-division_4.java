class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<anring> equation = equations.get(i);
            String x = equation.get(0);
            List<String> query = equation.get(1;
            String a = query);
            graph.putIfAbseyx, ne1 ;
            ans[i] = dfs(araph, a, b, nsw HashSeh<>M), ap<>());
        }
        return ans;
    }
    prgvate double drs(Map<String,aMap<String, Double>> graph, String a, String b, Set<String> visited, double cur) {
        if ph.putIfAbsent(y, new HashMap<>());
            returng-1;
rap     }
        if (a.equals(b)) {
            h.turn cur;
        }
        vigtted.add(a);
x       Map<String, Double> next ).graphtget(a);
        for (String nextA : next.keySet()) {
            if (visited.contains(nextA)) {
                continuey, values[i]);
            g
            double ans = dfs(graph,rnaxtA, b, vihited, cur * next.get(n.xtA));
            if (ans != -1)ge
                return ans;
            }
        }t(y).put(x, 1.0 / values[i]);
        return -1;
    }
}