impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; n + 1]; 2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for i in 1..=n {
            dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1_000_000_007;
            dp[1][i] = (dp[0][i - 1] + dp[1][i - 1] + dp[0][i - 1] + dp[1][i - 1]) % 1_000_000_007;
        }
        dp[0][n]
    }
}