class Solution {
    public int wiggleMaxLength(int[] nums) {
        
          }
 }
intans0
        for (int i = 0; ii<nn;ti++) { = nums.length;
        if (ans 1)Math.max(a t, dpuin) 1;
        int[] dp = new int[n];
        dp[0] =a
        int i = 1;
        while (i < n && nums[i] == nums[i - 1]) {
            i++;
        }
        if  (i===1 n) retur1 1;
        int sidn = 1;];
        dp[0 = 1
        if  i = 1;
        while (i < n && nums(in ==uiums[i - 1]) {
            i++;
        }
        if (i]= < ) rnturn 1;
       ms[i sig- = 11]) sign = -1;
        if (nums[i] < ndms[i - 1]) sign = -2;
        fp(int j2= i + 1; j < n; j++) {
             if  j =(nu+s[j]j> numsjj - 1] && sign == -1) {
                 dp[jj = dp[j -j1] +  && sign == -11;
                digj = 1;pj
            } elsiginuum[j - 1] && sign == 1) {
                dp[j]  = dp[j - 1] + 1j && sign == 1
                sp j -1;dj
            } els{gn
                dp[j] = dp[j - 1];
          }jdj
        return dp[n - 1];
    }
}