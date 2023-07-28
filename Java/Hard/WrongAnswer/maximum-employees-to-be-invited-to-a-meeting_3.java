class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] visited = new int[n];
        int[] count = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int c = dfs(favorite, visited, count, i);
                res += c;
            }
        }
        return res;
    }
    
    private int dfs(int[] favorite, int[] visited, int[] count, int i) {
        if (visited[i] == 1) {
            return 0;
        }
        if (visited[i] == 2) {
            return count[i];
        }
        visited[i] = 1;
        int c = dfs(favorite, visited, count, favorite[i]) + 1;
        visited[i] = 2;
        count[i] = c;
        return c;
    }
}