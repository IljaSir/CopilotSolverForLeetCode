class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[] group = new int[n+1];
        Arrays.fill(group, 0);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0 && !dfs(adj, group, 1, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adj, int[] group, int g, int i) {
        if (group[i] != 0) {
            return group[i] == g;
        }
        group[i] = g;
        for (int j : adj.get(i)) {
            if (!dfs(adj, group, -g, j)) {
                return false;
            }
        }
        return true;
    }
}