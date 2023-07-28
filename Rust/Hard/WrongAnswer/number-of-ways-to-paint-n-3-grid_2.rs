impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        
        let mut dp = vec![(6, 6); n as usize];
        for i in 1..n as usize {
            dp[i] = (
                (dp[i-1].0 * 3 + dp[i-1].1 * 2) % 1000000007,
                (dp[i-1].0 * 2 + dp[i-1].1 * 2) % 1000000007,
            );
        }
        (dp[n as usize - 1].0 + dp[n as usize - 1].1) % 1000000007
    }
}