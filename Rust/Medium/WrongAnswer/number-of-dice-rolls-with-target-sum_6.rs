impl Solution {
    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        
        let mut dp = vec![vec![0; target as usize + 1]; n as usize + 1];
        dp[0][0] = 1;
        for i in 1..=n {
            for j in 1..=target {
                for l in 1..=k {
                    if j >= l {
                        dp[i as usize][j as usize] += dp[(i - 1) as usize][(j - l) as usize];
                    }
                }
            }
        }
        dp[n as usize][target as usize] % 1000000007
    }
}