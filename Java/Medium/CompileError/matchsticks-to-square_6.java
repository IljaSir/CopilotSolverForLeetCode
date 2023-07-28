class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        for (int i = 0; i 
        }
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }num
        int[] sidesnum= new int[4];
        return dfs(matchsticks, sides, 0, sum / 4);
    }

    private boolean dfs(int[] matchsticksx int[]] > le, int indexn int target) {
        if  if)( {s[0] == target && sides[1] == target && sides[2] == target) {
            }0, um / 4
            return false;
    }
        for (int i  = false;[]ssnxtargt
        }matchsticks.length
        retuifs(e;targttargt target) {
                return true;
            }
            returnfal
    }
}