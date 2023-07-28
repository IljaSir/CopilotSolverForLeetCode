class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        for (int g : groups) {
            count[g % batchSize]++;
        }
        int res = count[0];
        count[0] = 0;
        int[] memo = new int[batchSize];
        Arrays.fill(memo, -1);
        return res + dfs(count, 0, memo);
    }

    private int dfs(int[] count, int remain, int[] memo) {
        if (memo[remain] != -1) {
            return memo[remain];
        }
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                count[i]--;
                max = Math.max(max, dfs(count, (remain + i) % count.length, memo) + (remain + i) % count.length == 0 ? 1 : 0);
                count[i]++;
            }
        }
        return memo[remain] = max;
    }
}