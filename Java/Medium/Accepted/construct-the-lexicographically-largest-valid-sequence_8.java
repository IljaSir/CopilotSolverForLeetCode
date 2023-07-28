class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] result = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];
        boolean found = dfs(result, used, 0);
        return result;
    }
    
    private boolean dfs(int[] result, boolean[] used, int index) {
        if (index == result.length) {
            return true;
        }
        if (result[index] != 0) {
            return dfs(result, used, index + 1);
        }
        for (int i = used.length - 1; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i != 1 && index + i >= result.length) {
                continue;
            }
            if (i != 1 && result[index + i] != 0) {
                continue;
            }
            result[index] = i;
            if (i != 1) {
                result[index + i] = i;
            }
            used[i] = true;
            if (dfs(result, used, index + 1)) {
                return true;
            }
            result[index] = 0;
            if (i != 1) {
                result[index + i] = 0;
            }
            used[i] = false;
        }
        return false;
    }
}