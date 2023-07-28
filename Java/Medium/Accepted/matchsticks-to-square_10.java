class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        return dfs(matchsticks, matchsticks.length - 1, sides, side);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sides, int side) {
        if (index == -1) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > side) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, index - 1, sides, side)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }
        return false;
    }
}