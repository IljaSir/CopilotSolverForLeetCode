class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[] rank = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> list : connections) {
            map.computeIfAbsent(list.get(0), k -> new ArrayList<>()).add(list.get(1));
            map.computeIfAbsent(list.get(1), k -> new ArrayList<>()).add(list.get(0));
        }
        dfs(0, 0, rank, low, parent, map, result);
        return result;
    }
    private void dfs(int node, int level, int[] rank, int[] low, int[] parent, Map<Integer, List<Integer>> map, List<List<Integer>> result) {
        rank[node] = level;
        low[node] = level;
        for (int child : map.getOrDefault(node, Collections.emptyList())) {
            if (rank[child] == 0) {
                parent[child] = node;
                dfs(child, level + 1, rank, low, parent, map, result);
                low[node] = Math.min(low[node], low[child]);
                if (low[child] > rank[node]) {
                    result.add(Arrays.asList(node, child));
                }
            } else if (child != parent[node]) {
                low[node] = Math.min(low[node], rank[child]);
            }
        }
    }
}