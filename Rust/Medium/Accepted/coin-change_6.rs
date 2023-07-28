impl Solution {
    pub fn coin_change(coins: Vec<i32>, amount: i32) -> i32 {
        

        let mut dp = vec![amount + 1; amount as usize + 1];
        dp[0] = 0;
        for i in 0..=amount as usize {
            for &coin in coins.iter() {
                if i >= coin as usize {
                    dp[i] = dp[i].min(dp[i - coin as usize] + 1);
                }
            }
        }
        if dp[amount as usize] == amount + 1 { -1 } else { dp[amount as usize] }
    }
}