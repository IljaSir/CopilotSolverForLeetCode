impl Solution {
    pub fn change(amount: i32, coins: Vec<i32>) -> i32 {
        

        let amount = amount as usize;
        let mut dp = vec![0; amount + 1];
        dp[0] = 1;
        for &coin in coins.iter() {
            let coin = coin as usize;
            for i in coin..amount + 1 {
                dp[i] += dp[i - coin];
            }
        }
        dp[amount]
    }
}