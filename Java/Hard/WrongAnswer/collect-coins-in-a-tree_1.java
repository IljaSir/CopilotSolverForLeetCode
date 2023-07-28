class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(graph, 0, -1, coins)[0];
    }

    // return [min path to collect all coins, min path to collect all coins with current node]
    private int[] dfs(List<List<Integer>> graph, int node, int parent, int[] coins) {
        int[] res = new int[2];
        int count = coins[node];
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] childRes = dfs(graph, child, node, coins);
            res[0] += childRes[0];
            count += childRes[1];
        }
        if (count == 0) {
            return res;
        }
        res[0] += (count - 1) * 2;
        res[1] = count;
        return res;
    }
}