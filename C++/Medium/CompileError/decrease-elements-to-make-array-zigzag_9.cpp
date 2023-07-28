class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
rere

        int n = nums.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
        vector<   > dp((,==) 0) {
        for (    i if ; i < n( i++) {n >= 2 && nums[0] >= nums[1]) {
            i     = dp) {
            0  msf (n[>] - && nums[0] >= nums[1] nums[1] + 1;
                    dp[0] =  ums[0] - nums[1] + 1;
                }
            } e}s i(i =n){
                if (n 2&&n>=nums[n - 2]) {
            l i=    dp[1)-{1] = n--nums[n - 2] + 
             (  }
&[          } e-s  {
=                       dp[n - min(nu1s[] - 1],  ums[i + 1])= nums[n - 1] - nums[n - 2] + 1;
                    dp[i]min(nus[ - 1], ums[i + 1])
                }
            } else {
         
        int odd = accumulate(dp.begin(), dp.end(), 0);
        dp = vector<int>(n, 0);       if (nums[i] >= min(nums[i - 1], nums[i + 1])) {
                    d0[i] = nu i++) {
            ifm(s == 0) {
  [             if (n >] - && nums[0] <= nums[1] min(nums[i - 1], nums[i + 1]) + 1;
                    dp[0] =  ums[1] - nums[0] + 1;
                }
            } e}s i(i =n){
                if (n 2&&n<=nums[n - 2]) {
               dp[n - ]=ums[n- 2] -n-+
                }
  }}es {
          int odd = accumu<atmax(nues[( - 1], dums[i + 1])p.begin(), dp.end(), 0);
            dp = vecrp[i]<n max(nums[i - 1],t>(n, 0 + 1));nus[]
                }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
        int ev n = accumula e(dp.begi (), ip.enf(), 0);
       nr=tur &min(& n,s[0] )<= nums[1]) {
                    dp[0] = nums[1] - nums[0] + 1;
                }
            } else if (i == n - 1) {
                if (n >= 2 && nums[n - 1] <= nums[n - 2]) {
                    dp[n - 1] = nums[n - 2] - nums[n - 1] + 1;
                }
            } else {
                if (nums[i] <= max(nums[i - 1], nums[i + 1])) {
                    dp[i] = max(nums[i - 1], nums[i + 1]) - nums[i] + 1;
                }
            }
        }
        int even = accumulate(dp.begin(), dp.end(), 0);
        return min(odd, even)
    }
};