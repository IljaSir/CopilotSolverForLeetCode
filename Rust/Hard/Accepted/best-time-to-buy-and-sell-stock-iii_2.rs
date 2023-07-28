impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut buy1 = std::i32::MAX;
        let mut sell1 = 0;
        let mut buy2 = std::i32::MAX;
        let mut sell2 = 0;
        for price in prices {
            buy1 = buy1.min(price);
            sell1 = sell1.max(price - buy1);
            buy2 = buy2.min(price - sell1);
            sell2 = sell2.max(price - buy2);
        }
        sell2
    }
}