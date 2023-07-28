class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] match = new int[n];
        int[] matchCount = new int[n];
        int[] visited = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (matchCount[i] == 0) {
                dfs(i, favorite, match, matchCount, visited, 1);
                res += matchCount[i];
            }
        }
        return res;
    }
    
    private void dfs(int i, int[] favorite, int[] match, int[] matchCount, int[] visited, int count) {
        int j = favorite[i];
        match[i] = j;
        visited[i] = 1;
        if (visited[j] == 0) {
            dfs(j, favorite, match, matchCount, visited, count + 1);
        } else if (match[j] == i) {
            matchCount[j] = count;
        } else if (matchCount[j] == 0) {
            dfs(match[j], favorite, match, matchCount, visited, count - 1);
            matchCount[j] = matchCount[match[j]];
        }
        visited[i] = 2;
    }
}