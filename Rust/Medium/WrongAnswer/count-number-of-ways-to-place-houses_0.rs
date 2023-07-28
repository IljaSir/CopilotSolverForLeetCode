impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; 2]; n + 1];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for i in 1..=n {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1_000_000_007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][1]) % 1_000_000_007;
        }
        (dp[n][0] + dp[n][1]) % 1_000_000_007
    }
}