impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut dp = vec![0; 3];
        for c in corridor.chars() {
            match c {
                'S' => {
                    dp[0] += dp[0];
                    dp[1] += dp[1];
                    dp[2] += dp[2];
                    dp[0] += 1;
                }
                'P' => {
                    dp[1] += dp[0];
                    dp[2] += dp[1];
                }
                _ => {}
            }
            dp[0] %= 1_000_000_007;
            dp[1] %= 1_000_000_007;
            dp[2] %= 1_000_000_007;
        }
        dp[2] as i32
    }
}