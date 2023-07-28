impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        

        let mut dp = vec![amount + 1; (amount + 1) as usize];
        dp[0] = 0;
        for i in 1..=amount {
            for coin in &coins {
                if *coin <= i {
                    dp[i as usize] = dp[i as usize].min(dp[(i - coin) as usize] + 1);
                }
            }
        }
        if dp[amount as usize] == amount + 1 {
            return -1;
        }
        dp[amount as usize]
    }
}