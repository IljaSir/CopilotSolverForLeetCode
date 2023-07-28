impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut i = 0;
        while i < prices.len() - 1 {
            let mut j = i + 1;
            while j < prices.len() {
                if prices[i] >= prices[j] {
                    res.push(prices[i] - prices[j]);
                    break;
                }
                j += 1;
            }
            if j == prices.len() {
                res.push(prices[i]);
            }
            i += 1;
        }
        res.push(prices[i]);
        res
    }
}