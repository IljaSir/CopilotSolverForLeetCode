impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        

        let mut dp = vec![-1; (amount + 1) as usize];
        dp[0] = 0;
        for i in 0..=amount {
            for c in &coins {
                if i + c <= amount && dp[(i + c) as usize] != -1 {
                    if dp[i as usize] == -1 {
                        dp[i as usize] = dp[(i + c) as usize] + 1;
                    } else {
                        dp[i as usize] = std::cmp::min(dp[i as usize], dp[(i + c) as usize] + 1);
                    }
                }
            }
        }
        dp[amount as usize]
    }
}