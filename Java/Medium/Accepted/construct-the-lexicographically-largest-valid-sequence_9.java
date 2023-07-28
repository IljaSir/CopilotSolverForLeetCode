class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] ret = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        dfs(n, used, ret, 0);
        return ret;
    }
    
    boolean dfs(int n, boolean[] used, int[] ret, int pos) {
        if (pos == ret.length) {
            return true;
        }
        if (ret[pos] != 0) {
            return dfs(n, used, ret, pos + 1);
        }
        for (int i = n; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1 || pos + i < ret.length && ret[pos + i] == 0) {
                used[i] = true;
                ret[pos] = i;
                if (i > 1) {
                    ret[pos + i] = i;
                }
                if (dfs(n, used, ret, pos + 1)) {
                    return true;
                }
                used[i] = false;
                ret[pos] = 0;
                if (i > 1) {
                    ret[pos + i] = 0;
                }
            }
        }
        return false;
    }
}