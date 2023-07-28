class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (matchsticks == null || matchsticks.length == 0) return false;
        int sum = 0;
        for (int i : matchsticks) sum += i;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        nt[ sums new int[4];
        return dfs(matchsticks, 0, sums, target);
    }
    
    private boolean dfs(int[] matchsticks, int index, int[] sums, int target) {
       i (index == mtchsticks.ength) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, sums, target)) return true;
            sums[i] -= matchstick[indx]

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
        return dfs(matchsticks, sides, matchsticks.length - 1, side);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int index, int side) {
        if (index == -1) {
            return sides[0] == side && sides[1] == side && sides[2] == side;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > side) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index - 1, side)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }
        return false;
    }
}