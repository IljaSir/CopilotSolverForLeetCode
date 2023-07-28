impl Solution {
    pub fn count_house_placements(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        dp[0] = 0;
        dp[1] = 6;
        dp[2] = 6;
        for i in 3..=n as usize {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 1000000007;
        }
        dp[n as usize]
    }
}