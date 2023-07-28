impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; m + 1];
        for k in 0..m {
            for i in 0..=k {
                let j = k - i;
                let a = if i == 0 { i32::MIN } else { dp[i - 1][j] + nums[i - 1] * multipliers[k] };
                let b = if j == 0 { i32::MIN } else { dp[i][j - 1] + nums[n - j] * multipliers[k] };
                dp[i][j] = a.max(b);
            }
        }
        dp[m][0]
    }
}