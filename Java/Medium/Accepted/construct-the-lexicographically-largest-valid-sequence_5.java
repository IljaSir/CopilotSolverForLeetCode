class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] res = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];
        dfs(res, 0, used);
        return res;
    }
    
    private boolean dfs(int[] res, int idx, boolean[] used) {
        if (idx == res.length) {
            return true;
        }
        if (res[idx] != 0) {
            return dfs(res, idx + 1, used);
        }
        for (int i = used.length - 1; i > 0; i--) {
            if (used[i]) {
                continue;
            }
            if (i != 1 && (idx + i >= res.length || res[idx + i] != 0)) {
                continue;
            }
            res[idx] = i;
            used[i] = true;
            if (i != 1) {
                res[idx + i] = i;
            }
            if (dfs(res, idx + 1, used)) {
                return true;
            }
            res[idx] = 0;
            used[i] = false;
            if (i != 1) {
                res[idx + i] = 0;
            }
        }
        return false;
    }
}