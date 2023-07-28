class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        long res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        long[] sum = new long[n];
        long[] count = new long[n];
        dfs(map, visited, sum, count, price, 0);
        res = sum[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(sum[i] - count[i] * price[i], sum[0] - sum[i] - (n - count[i]) * price[i]));
        }
        return res;
    }
    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, long[] sum, long[] count, int[] price, int node) {
        visited[node] = true;
        sum[node] = price[node];
        count[node] = 1;
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            if (!visited[next]) {
                dfs(map, visited, sum, count, price, next);
                sum[node] += sum[next];
                count[node] += count[next];
            }
        }
    }
}