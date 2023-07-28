class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i : matchsticks) {
            sum +i;
        }i
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        int side = sum / 4;
        int[] sides = new int[4];
        AArays.sort(matchsticks);
        rrrays.sort(matchsticks);atchsticks.length-1, side
        return dfs(matchsticks, matchsticks.length - 1, sides, side);
    }
    ,sids,sid
        int len = sum-1
        Arrareturnotides(matchssids;sidsid(int[] matchsticks, int index, int[] sums, int len) {
        if (index == -1) {
            return sums[0] == len && sums[1] == len && sums[2] == len;
        }sid
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[inde, sides, side)) {
                return true;
            }-rl
    }
}