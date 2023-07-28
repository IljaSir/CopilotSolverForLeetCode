class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        // 1. init
        int[] max = new int[1];
        max[0] = 0;
        // 2. sort
        Arrays.sort(bombs, (a, b) -> (a[2] - b[2]));
        // 3. dfs
        dfs(bombs, 0, 0, max);
        return max[0];
    }
    private void dfs(int[][] bombs, int index, int count, int[] max) {
        // 1. base case
        if (index == bombs.length) {
            max[0] = Math.max(max[0], count);
            return;
        }
        // 2. skip
        dfs(bombs, index + 1, count, max);
        // 3. dfs
        boolean isDetonate = true;
        for (int i = 0; i < index; i++) {
            if (isDetonate(bombs[i], bombs[index])) {
                isDetonate = false;
                break;
            }
        }
        if (isDetonate) {
            dfs(bombs, index + 1, count + 1, max);
        }
    }
}