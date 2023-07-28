impl Solution {
    pub fn largest_number(cost: Vec<i32>, target: i32) -> String {
        
        let mut dp = vec![i32::MIN; target as usize + 1];
        dp[0] = 0;
        for t in 1..=target as usize {
            for i in 0..9 {
                if t >= cost[i] as usize {
                    dp[t] = dp[t].max(dp[t - cost[i] as usize] + 1);
                }
            }
        }
        if dp[target as usize] < 0 {
            "0".to_string()
        } else {
            let mut ans = String::new();
            for i in (0..9).rev() {
                while target >= cost[i] && dp[target as usize] == dp[(target - cost[i]) as usize] + 1 {
                    ans.push((i + 1) as u8 + '0' as u8);
                    target -= cost[i];
                }
            }
            ans
        }
    }
}