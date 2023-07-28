impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![std::i32::MAX; k as usize + 1]; n + 1];
        let mut sub = vec![0; n + 1];
        for i in 0..n {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for i in 1..=n {
            for j in 1..=k as usize {
                for p in 0..i {
                    dp[i][j] = std::cmp::min(dp[i][j], std::cmp::max(dp[p][j - 1], sub[i] - sub[p]));
                }
            }
        }
        dp[n][k as usize]
    }
}