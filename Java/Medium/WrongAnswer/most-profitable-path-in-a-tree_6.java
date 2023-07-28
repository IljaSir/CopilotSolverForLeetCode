class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[] dp = new int[amount.length];
        int[] visited = new int[amount.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Arrays.fill(visited, -1);
        return dfs(map, amount, bob, 0, dp, visited);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int[] amount, int bob, int node, int[] dp, int[] visited){
        if(node == bob)
            return 0;
        if(visited[node] != -1)
            return dp[node];
        visited[node] = 1;
        int max = Integer.MIN_VALUE;
        for(int next: map.get(node)){
            int nextMax = dfs(map, amount, bob, next, dp, visited);
            if(nextMax != Integer.MIN_VALUE)
                max = Math.max(max, nextMax + (amount[node] < 0 ? amount[node] : amount[node] / 2));
        }
        return dp[node] = max;
    }
}