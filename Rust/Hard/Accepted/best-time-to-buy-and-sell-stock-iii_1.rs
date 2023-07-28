impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut buy1 = std::i32::MIN;
        let mut sell1 = 0;
        let mut buy2 = std::i32::MIN;
        let mut sell2 = 0;
        for p in prices {
            buy1 = buy1.max(-p);
            sell1 = sell1.max(buy1 + p);
            buy2 = buy2.max(sell1 - p);
            sell2 = sell2.max(buy2 + p);
        }
        sell2
    }
}