impl Solution {
    pub fn largest_number(cost: Vec<i32>, target: i32) -> String {
        
        let mut dp = vec![vec![0; target as usize + 1]; cost.len() + 1];
        for i in 1..=cost.len() {
            for j in 1..=target as usize {
                dp[i][j] = dp[i - 1][j];
                if j >= cost[i - 1] as usize {
                    dp[i][j] = dp[i][j].max(dp[i][j - cost[i - 1] as usize] + 1);
                }
            }
        }
        if dp[cost.len()][target as usize] == 0 {
            return "0".to_string();
        }
        let mut res = String::new();
        let mut i = cost.len();
        let mut j = target as usize;
        while i > 0 && j > 0 {
            if dp[i][j] == dp[i - 1][j] {
                i -= 1;
            } else {
                res.push((i as u8 + '0' as u8) as char);
                j -= cost[i - 1] as usize;
            }
        }
        res
    }
}