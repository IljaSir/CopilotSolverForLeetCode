impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut max = 0;
        for i in 0..prices.len() {
            min = min.min(prices[i]);
            max = max.max(prices[i] - min);
        }
        max
    }
}