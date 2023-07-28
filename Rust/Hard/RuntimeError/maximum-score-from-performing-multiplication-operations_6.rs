impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; 2];
        for i in 0..=m {
            dp[0][i] = std::i32::MIN;
            dp[1][i] = std::i32::MIN;
        }
        dp[0][0] = 0;
        for i in 1..=m {
            for j in 0..=i {
                let k = i - j;
                if j > 0 {
                    dp[i & 1][j] = dp[i & 1][j].max(dp[!(i & 1)][j - 1] + nums[j - 1] * multipliers[i - 1]);
                }
                if k > 0 {
                    dp[i & 1][j] = dp[i & 1][j].max(dp[!(i & 1)][j] + nums[n - k] * multipliers[i - 1]);
                }
            }
        }
        dp[m & 1].iter().max().unwrap().to_owned()
    }
}