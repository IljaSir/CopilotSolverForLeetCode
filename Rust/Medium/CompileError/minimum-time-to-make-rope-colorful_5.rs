impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![std::i32::MAX; 3]; colors.len()];
        let mut pre = vec![vec![0; 3]; colors.len()];
        for i in 0..colors.len() {
            for j in 0..3 {
                if colors.chars().nth(i).unwrap() as i32 - 'a' as i32 == j {
                    pre[i][j] = 1;
                }
            }
        }
        for i in 1..colors.len() {
            for j in 0..3 {
                for k in 0..3 {
                    if k != j {
                        dp[i][j] = std::cmp::min(dp[i][j], dp[i-1][k] + needed_time[i] * pre[i][j]);
                    }
                }
            }
        }
        std::cmp::min(dp[colors.len()-1][0], std::cmp::min(dp[colors.len()-1][1], dp[colors.len()-1][2]))
    }
}