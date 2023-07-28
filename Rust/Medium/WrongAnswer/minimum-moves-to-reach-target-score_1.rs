impl Solution {
    pub fn min_moves(target: i32, max_doubles: i32) -> i32 {
        
        let mut dp = vec![0; target as usize + 1];
        for i in 1..=target {
            dp[i as usize] = dp[(i - 1) as usize] + 1;
            for j in 1..=max_doubles {
                if i - (1 << j) < 0 {
                    break;
                }
                dp[i as usize] = dp[i as usize].min(dp[(i - (1 << j)) as usize] + 1);
            }
        }
        dp[target as usize]
    }
}