impl Solution {
    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        
        let mut dp = vec![vec![0; target as usize + 1]; n as usize + 1];
        dp[0][0] = 1;
        for i in 1..=n {
            for j in 1..=target {
                for d in 1..=k {
                    if j >= d {
                        dp[i as usize][j as usize] += dp[(i - 1) as usize][(j - d) as usize];
                        dp[i as usize][j as usize] %= 1_000_000_007;
                    }
                }
            }
        }
        dp[n as usize][target as usize]
    }
}