impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; 2];
        for i in 0..m {
            for j in 0..=i {
                let k = i - j;
                let a = if j == 0 { std::i32::MIN } else { dp[i % 2][j - 1] + nums[j - 1] * multipliers[i] };
                let b = if k == 0 { std::i32::MIN } else { dp[(i - 1) % 2][j] + nums[n - k] * multipliers[i] };
                dp[i % 2][j] = std::cmp::max(a, b);
            }
        }
        dp[m % 2][m]
    }
}