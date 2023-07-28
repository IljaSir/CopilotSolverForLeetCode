impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut i = 0;
        while i < prices.len() {
            let mut j = i + 1;
            while j < prices.len() {
                if prices[j] <= prices[i] {
                    result.push(prices[i] - prices[j]);
                    break;
                }
                j += 1;
            }
            if j == prices.len() {
                result.push(prices[i]);
            }
            i += 1;
        }
        result
    }
}