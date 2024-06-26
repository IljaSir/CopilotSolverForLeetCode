impl Solution {
    pub fn soup_servings(n: i32) -> f64 {
        
        if n > 4800 {
            return 1.0;
        }
        let mut dp = vec![vec![0.0; n as usize / 25 + 1]; n as usize / 25 + 1];
        dp[0][0] = 0.5;
        for i in 0..=n as usize / 25 {
            for j in 0..=n as usize / 25 {
                if i > 0 {
                    dp[i][j] += 0.25 * dp[i.saturating_sub(1).min(j)][j.saturating_sub(1).min(i)];
                }
                if j > 0 {
                    dp[i][j] += 0.25 * dp[i.saturating_sub(4).min(j)][j.saturating_sub(4).min(i)];
                }
                if i > 0 && j > 0 {
                    dp[i][j] += 0.25 * dp[i.saturating_sub(3).min(j)][j.saturating_sub(3).min(i)];
                }
                if i > 0 && j > 0 {
                    dp[i][j] += 0.25 * dp[i.saturating_sub(2).min(j)][j.saturating_sub(2).min(i)];
                }
            }
        }
        dp[n as usize / 25][n as usize / 25]
    }
}