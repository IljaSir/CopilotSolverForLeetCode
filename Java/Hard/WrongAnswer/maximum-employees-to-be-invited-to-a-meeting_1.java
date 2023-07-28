class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                ans += dfs(i, favorite, visited);
            }
        }
        return ans;
    }

    private int dfs(int i, int[] favorite, int[] visited) {
        if (visited[i] == 1) {
            return 0;
        }
        visited[i] = 1;
        int ans = 1;
        ans += dfs(favorite[i], favorite, visited);
        visited[i] = 2;
        return ans;
    }
}