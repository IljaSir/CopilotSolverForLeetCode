class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        boolean[] visited = new boolean[matchsticks.length];
        return dfs(matchsticks, visited, 0, target, 0, 0);
    }

    private boolean dfs(int[] matchsticks, boolean[] visited, int index, int target, int sum, int count) {
        if (target * 4 == sum) {
            return true;
        }
        if (count == 3) {
            return false;
        }
        for (int i = index; i < matchsticks.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (sum + matchsticks[i] > target) {
                continue;
            }
            visited[i] = true;
            if (dfs(matchsticks, visited, i + 1, target, sum + matchsticks[i], count)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}