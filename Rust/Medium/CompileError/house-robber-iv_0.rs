impl Solution {
    pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            for j in i..n {
                dp[i][j] = nums[i..=j].iter().max().unwrap();
            }
        }
        let mut dp = vec![vec![std::i32::MAX; n]; k as usize];
        for i in 0..n {
            dp[0][i] = dp[0][i].min(*dp[0].get(i - 1).unwrap_or(&0));
            dp[0][i] = dp[0][i].min(dp[0][i - 1]);
        }
        for i in 1..k as usize {
            for j in i..n {
                for l in i - 1..j {
                    dp[i][j] = dp[i][j].min(dp[i - 1][l].max(dp[l + 1][j]));
                }
            }
        }
        dp[k as usize - 1][n - 1]
    }
}