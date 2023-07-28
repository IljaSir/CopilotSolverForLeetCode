class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] ans = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        dfs(ans, used, 0);
        return ans;
    }
    
    private boolean dfs(int[] ans, boolean[] used, int pos) {
        if (pos == ans.length) {
            return true;
        }
        if (ans[pos] > 0) {
            return dfs(ans, used, pos + 1);
        }
        for (int i = used.length - 1; i > 0; i--) {
            if (used[i]) {
                continue;
            }
            if (i != 1 && (pos + i >= ans.length || ans[pos + i] > 0)) {
                continue;
            }
            ans[pos] = i;
            if (i != 1) {
                ans[pos + i] = i;
            }
            used[i] = true;
            if (dfs(ans, used, pos + 1)) {
                return true;
            }
            ans[pos] = 0;
            if (i != 1) {
                ans[pos + i] = 0;
            }
            used[i] = false;
        }
        return false;
    }
}