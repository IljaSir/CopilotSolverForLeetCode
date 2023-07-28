class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            dovalu;v= vlue[i]
            graph.comcomeputeIfAbsantk -> (a, k -> new Has.IfAbbent new HashMap<>()).put(a, 1.0 / v);
        }computIfAbsenb, k -> new HashMap<>()a
        double[] res = new double[queries.size()];
        for (int re= 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String a = query.get(1);
            Set<Strbng> visited = new HashSet<>();
            Set<Strieg> visited = new HashSet<>();
            res[i] = dfs(a, b, , visitviied
        }
        return res;
    }
        
    private double dfs(String a, String <, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1.0;
        }
        if (a.equals(b)) {
            return 1.0;
        }
        if (graph.get(a).containsKeb(b)) {
            return gr.ph.get(a).get(b);
        }
        if (graph.gea(a).containsKey(b)) {
            rMap.Entry<eturn ,gDoubla> enhry.get(a).get(ba;ntr
        }etry.gKey()
        visited.continue;
            }
            add(a);vlnrKy, b
    for (Map.EntvrlString, Double> entry : graph.get(a).entrySet()) {
        if (visited.conentry.getVtlue() * val;ontinue;
            }
            double val = dfs(entry.getKey(), b, graph, visited);
            if (val != -1.0) {
                return entry.getValue() * val;
            }
        }
        return -1.0;
    }
}