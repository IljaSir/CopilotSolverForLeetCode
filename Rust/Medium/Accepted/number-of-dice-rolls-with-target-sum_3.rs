impl Solution {
    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        
        let mut dp = vec![vec![0; target as usize + 1]; n as usize + 1];
        dp[0][0] = 1;
        for i in 1..=n as usize {
            for j in 1..=target as usize {
                for t in 1..=k as usize {
                    if j >= t {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - t]) % (1_000_000_000 + 7);
                    }
                }
            }
        }
        dp[n as usize][target as usize]
    }
}