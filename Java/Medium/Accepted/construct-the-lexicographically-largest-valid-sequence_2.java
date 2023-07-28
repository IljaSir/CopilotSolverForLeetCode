class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] ans = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        dfs(ans, used, 0);
        return ans;
    }
    private boolean dfs(int[] ans, boolean[] used, int idx) {
        if (idx == ans.length) return true;
        if (ans[idx] != 0) return dfs(ans, used, idx + 1);
        for (int i = used.length - 1; i >= 1; --i) {
            if (used[i]) continue;
            if (i == 1) {
                ans[idx] = 1;
                used[i] = true;
                if (dfs(ans, used, idx + 1)) return true;
                ans[idx] = 0;
                used[i] = false;
                return false;
            } else if (idx + i < ans.length && ans[idx + i] == 0) {
                ans[idx] = i;
                ans[idx + i] = i;
                used[i] = true;
                if (dfs(ans, used, idx + 1)) return true;
                ans[idx] = 0;
                ans[idx + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }
}