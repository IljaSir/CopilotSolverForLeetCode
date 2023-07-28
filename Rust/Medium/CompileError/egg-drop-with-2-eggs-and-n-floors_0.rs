impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; n + 1]; 3];
        for i in 1..=n {
            dp[1][i] = i;
        }
        for i in 2..=2 {
            for j in 1..=n {
                let mut k = 1;
                let mut min = std::i32::MAX;
                while k <= j {
                    let broken = dp[i - 1][k - 1];
                    let not_broken = dp[i][j - k];
                    min = min.min(broken.max(not_broken));
                    k += 1;
                }
                dp[i][j] = min + 1;
            }
        }
        dp[2][n] as i32
    }
}