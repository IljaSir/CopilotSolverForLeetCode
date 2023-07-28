class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(map, target, t, 1, 1.0);
    }

    private double dfs(Map<Integer, List<Integer>> map, int target, int t, int cur, double prob) {
        if (t == 0) {
            return cur == target ? prob : 0;
        }
        if (!map.containsKey(cur)) {
            return 0;
        }
        List<Integer> nexts = map.get(cur);
        map.remove(cur);
        double p = 0;
        for (int next : nexts) {
            p += dfs(map, target, t - 1, next, prob / nexts.size());
        }
        return p;
    }
}