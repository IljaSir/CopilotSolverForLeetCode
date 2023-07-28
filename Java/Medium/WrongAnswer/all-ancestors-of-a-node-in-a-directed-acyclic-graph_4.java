class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, map, res);
        }
        return res;
    }
    private void dfs(int node, Map<Integer, List<Integer>> map, List<List<Integer>> res) {
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                res.get(node).add(next);
                dfs(next, map, res);
            }
        }
    }
}