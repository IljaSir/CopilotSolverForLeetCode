class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        double[] res = new double[1];
        dfs(map, t, target, 1, 1.0, res);
        return res[0];
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int t, int target, int cur, double prob, double[] res) {
        if (t < 0) return;
        if (cur == target && t == 0) {
            res[0] = prob;
            return;
        }
        List<Integer> next = map.getOrDefault(cur, new ArrayList<>());
        if (next.size() == 0) {
            if (cur == target) res[0] = prob;
            return;
        }
        for (int n : next) {
            map.get(n).remove((Integer) cur);
            dfs(map, t - 1, target, n, prob / next.size(), res);
            map.get(n).add(cur);
        }
    }
}