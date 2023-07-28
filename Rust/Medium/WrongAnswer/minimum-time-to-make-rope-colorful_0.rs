impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; colors.len()];
        dp[0][colors.as_bytes()[0] as usize - 'a' as usize] = needed_time[0];
        for i in 1..colors.len() {
            let c = colors.as_bytes()[i] as usize - 'a' as usize;
            for j in 0..3 {
                if j == c {
                    dp[i][j] = dp[i-1][j] + needed_time[i];
                } else {
                    dp[i][j] = dp[i-1][j].min(dp[i-1][c]) + needed_time[i];
                }
            }
        }
        dp[colors.len()-1].iter().min().unwrap().to_owned()
    }
}