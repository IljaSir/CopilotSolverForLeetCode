impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut prices = prices;
        let n = prices.len();
        for i in 0..n {
            for j in i+1..n {
                if prices[j] <= prices[i] {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        prices
    }
}