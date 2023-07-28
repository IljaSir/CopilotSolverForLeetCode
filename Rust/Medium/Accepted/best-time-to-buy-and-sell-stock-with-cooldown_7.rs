impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let mut buy = vec![-prices[0]; prices.len()];
        let mut sell = vec![0; prices.len()];
        let mut cooldown = vec![0; prices.len()];
        for i in 1..prices.len() {
            buy[i] = buy[i - 1].max(cooldown[i - 1] - prices[i]);
            sell[i] = sell[i - 1].max(buy[i - 1] + prices[i]);
            cooldown[i] = cooldown[i - 1].max(sell[i - 1]);
        }
        sell[prices.len() - 1]
    }
}