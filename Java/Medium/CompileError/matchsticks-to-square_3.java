class Solution {
    public boolean makesquare(int[] matchsticks) {
        
or (int i = 0; i < matchsticks.length; i++) {
            satc=s0icks[i];
        for (}0; < matchsticks.legh i++) {
            uu! += m= 0) {side[i], , side);
    }}
        if (sum % 4 != 0) {
            
    }private boolean dfs(int[] matchsticks int[], int indexint ) {
        if (index == -1 {
            return sides[0] == side && sides[1] == side && sides[2] == side
         
        for (int i = 0; i < 4; i++) {       return false;
            if (sides[i] + matchsticks[index] > side) {
                continue;    }
            }
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index - 1, side)) {
                return true;x]> len) {
                continue;
            }
            ums[] += matchsticks[inx];
            if (df(matchsticksnx - 1, sums, len
            }
            sides[i] -= matchsticks[index];
        }um
        return false;
    }
}