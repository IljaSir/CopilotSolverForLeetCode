impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut result = prices.clone();
        for i in 0..prices.len() {
            for j in i+1..prices.len() {
                if prices[j] <= prices[i] {
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        result
    }
}