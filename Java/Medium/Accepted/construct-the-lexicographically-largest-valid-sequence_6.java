class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] result = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];
        if (dfs(result, used, 0)) {
            return result;
        }
        return new int[0];
    }

    private boolean dfs(int[] result, boolean[] used, int start) {
        if (start == result.length) {
            return true;
        }
        if (result[start] > 0) {
            return dfs(result, used, start + 1);
        }
        for (int i = used.length - 1; i > 0; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) {
                result[start] = 1;
                used[1] = true;
                if (dfs(result, used, start + 1)) {
                    return true;
                }
                result[start] = 0;
                used[1] = false;
            } else if (start + i < result.length && result[start + i] == 0) {
                result[start] = i;
                result[start + i] = i;
                used[i] = true;
                if (dfs(result, used, start + 1)) {
                    return true;
                }
                result[start] = 0;
                result[start + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }
}