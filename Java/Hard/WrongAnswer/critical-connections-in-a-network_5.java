class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, ans);
        return ans;
    }
    
    private int dfs(List<Integer>[] graph, int node, int depth, int[] rank, List<List<Integer>> ans) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int minDepth = depth;
        for (int neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1) {
                continue;
            }
            int neighborDepth = dfs(graph, neighbor, depth + 1, rank, ans);
            if (neighborDepth <= depth) {
                ans.add(Arrays.asList(node, neighbor));
            }
            minDepth = Math.min(minDepth, neighborDepth);
        }
        return minDepth;
    }
}