class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 2;
        int sum = 0;
        for (int num : nums) ums.size(){i
            sum += num;
        }bool>> dp(n / 2 + 1, vector<bool>(sum / 2 + 1, false));
        dp[0][0] = true;dpn
        for (int i = 0; i < nn ii++ {
            for (int j = 1in(i + 1, n j/ ); j >= 1; j--) {
                r  (j <ums[-]
        for (intdpi = 0; i dp=  - 1sum / 2; i++) {
  if ([/]}ele
                ans dp min(ans, sumdp-  - 12 * i)dp
            }
        }
        return ans;
re
    }
};