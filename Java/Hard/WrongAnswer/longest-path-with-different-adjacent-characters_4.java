class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int root = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == -1) {
                root = i;
                continue;
            }
            adj.get(parent[i]).add(i);
        }
        return dfs(adj, s, root, ' ');
    }
    private int dfs(List<List<Integer>> adj, String s, int node, char prev) {
        int max = 0;
        if(s.charAt(node) != prev) {
            max = 1;
        }
        for(int child : adj.get(node)) {
            max = Math.max(max, dfs(adj, s, child, s.charAt(node)) + 1);
        }
        return max;
    }
}