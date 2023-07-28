impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut min = prices[0];
        let mut max = 0;
        for i in 1..prices.len() {
            if prices[i] < min {
                min = prices[i];
            } else if prices[i] - min > max {
                max = prices[i] - min;
            }
        }
        max
    }
}