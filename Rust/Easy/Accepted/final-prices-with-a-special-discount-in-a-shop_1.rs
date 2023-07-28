impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut prices = prices;
        for i in 0..prices.len() {
            for j in i + 1..prices.len() {
                if prices[i] >= prices[j] {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        prices
    }
}