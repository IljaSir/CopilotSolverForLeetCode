impl Solution {
    pub fn largest_number(cost: Vec<i32>, target: i32) -> String {
        
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for i in 1..=target as usize {
            for j in 0..9 {
                if i as i32 >= cost[j] && dp[i - cost[j] as usize] != 0 {
                    dp[i] = dp[i - cost[j] as usize].max(j as i32 + 1);
                }
            }
        }
        if dp[target as usize] == 0 {
            return "0".to_string();
        }
        let mut ans = String::new();
        let mut i = target as usize;
        while i > 0 {
            ans.push((dp[i] - 1 + b'1') as char);
            i -= cost[dp[i] as usize - 1] as usize;
        }
        ans
    }
}