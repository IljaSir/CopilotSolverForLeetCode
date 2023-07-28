class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] visited = new int[n];
        int[] inCycle = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int j = i;
                while (visited[j] == 0) {
                    visited[j] = 1;
                    j = favorite[j];
                }
                if (visited[j] == 1) {
                    while (visited[j] == 1) {
                        visited[j] = 2;
                        j = favorite[j];
                    }
                }
                if (visited[j] == 2) {
                    while (visited[j] == 2) {
                        inCycle[j] = 1;
                        j = favorite[j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (inCycle[i] == 1) {
                int j = i;
                while (next[j] != j) {
                    j = next[j];
                }
                next[j] = favorite[i];
                ans++;
            }
        }
        return ans;
    }
}