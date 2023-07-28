class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] r : roads) {
            graph.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
            graph.computeIfAbsent(r[1], k -> new ArrayList<>()).add(r[0]);
        }
        int[] values = new int[n];
        Arrays.fill(values, 1);
        int[] max = new int[1];
        dfs(graph, values, 0, 0, max);
        return max[0];
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, int[] values, int node, int sum, int[] max) {
        if (graph.get(node) == null) {
            max[0] = Math.max(max[0], sum);
            return;
        }
        for (int next : graph.get(node)) {
            if (values[next] == 0) {
                continue;
            }
            int tmp = values[next];
            values[next] = 0;
            dfs(graph, values, next, sum + tmp, max);
            values[next] = tmp;
        }
    }
}