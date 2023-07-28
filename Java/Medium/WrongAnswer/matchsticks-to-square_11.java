class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        boolean[] used = new boolean[matchsticks.length];
        return dfs(0, 0, matchsticks, target, used);
    }
    private boolean dfs(int start, int current, int[] matchsticks, int target, boolean[] used) {
        if (current == target) {
            if (start == 0) {
                return dfs(0, 0, matchsticks, target, used);
            }
            return true;
        }
        for (int i = start; i < matchsticks.length; i++) {
            if (used[i]) continue;
            if (current + matchsticks[i] > target) continue;
            used[i] = true;
            if (dfs(i + 1, current + matchsticks[i], matchsticks, target, used)) return true;
            used[i] = false;
        }
        return false;
    }
}