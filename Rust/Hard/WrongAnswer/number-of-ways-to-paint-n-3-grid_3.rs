impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        
        let mut dp = vec![[6, 6]; n as usize];
        for i in 1..n as usize {
            dp[i][0] = dp[i - 1].iter().sum::<i32>() % 1_000_000_007;
            dp[i][1] = dp[i - 1].iter().sum::<i32>() % 1_000_000_007;
            for j in 0..2 {
                dp[i][j] -= dp[i - 1][j];
                dp[i][j] %= 1_000_000_007;
            }
        }
        (dp[n as usize - 1].iter().sum::<i32>() % 1_000_000_007) as i32
    }
}