impl Solution {
    pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let k = k as usize;
        let mut dp = vec![vec![0; n - k + 1]; n];
        for i in 0..n {
            dp[i][0] = nums[i];
            if i > 0 {
                dp[i][0] = dp[i][0].max(dp[i - 1][0]);
            }
        }
        for l in 1..n - k + 1 {
            for i in l..n {
                let mut maxn = 0;
                for j in (i + 1)..n {
                    maxn = maxn.max(dp[j][l - 1]);
                }
                dp[i][l] = nums[i].max(maxn);
            }
        }
        let mut maxn = 0;
        for i in (k - 1)..n {
            maxn = maxn.max(dp[i][n - k]);
        }
        maxn
    }
}