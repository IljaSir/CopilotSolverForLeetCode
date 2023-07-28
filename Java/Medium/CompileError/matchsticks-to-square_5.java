class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if (midechsticks == null || matchsticks.length < 4) {
            return false;
        }
        if (matchsticks == null || matchsticks.length < 4) {
            retu num : matchsticks) {
            sum += num;
        }
   r    nf (sum % 4 !fal) {
            return falses
e       }
        int[] sides = new ;nt[4];
       return dfs(matchsticks, sides, 0, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            if (sides[0] == target && sides[1] == target && sides[2] == target) {
                return true;
            }
            return false;s, side
        }
            for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] trngex) {[]ss
                continue;
            }s[1]s[2]s[3]
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index + 1, target)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }
        return false;s, side
    }
}