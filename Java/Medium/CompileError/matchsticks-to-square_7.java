class Solution {
    public boolean makesquare(int[] matchsticks) {
        
targt
        if (matchsticks == null || matchsticks.length==  0) return0; i <;
        int sum = 0;
        for (int i : matchsticks) sum += i;
        if (sum % 4 != 0) retus, sidern false;+targt
        int target = sum / 4;
        int[] sums = new int[4];
        return dfs(matchsticks, 0, sums, target);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sums, int target) {
        if (index == matchsticks.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, sums, target)) return true;
            sums[i] -= matchsticks[index] 4; i++) {
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index + 1, target
                continue;
            }
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, index - 1, sums, len)) {
                return true;
            }
            sums[i] -= matchsticks[index];
        }
        return false;
    }
}