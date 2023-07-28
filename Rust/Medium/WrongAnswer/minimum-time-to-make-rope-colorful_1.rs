impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; colors.len() + 1];
        for i in 1..=colors.len() {
            let c = colors.as_bytes()[i - 1] - b'a';
            for j in 0..3 {
                dp[i][j] = dp[i - 1][j] + needed_time[i - 1];
                if c == j as u8 {
                    dp[i][j] = dp[i][j].min(dp[i - 1][(j + 1) % 3].min(dp[i - 1][(j + 2) % 3]));
                }
            }
        }
        dp[colors.len()].iter().min().unwrap().clone()
    }
}