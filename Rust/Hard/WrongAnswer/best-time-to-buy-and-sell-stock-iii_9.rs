impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut profit = 0;
        let mut min = 0;
        let mut max = 0;
        let mut min_index = 0;
        let mut max_index = 0;
        for i in 0..prices.len() {
            if prices[i] < min {
                min = prices[i];
                min_index = i;
                max = 0;
                max_index = 0;
            }
            if prices[i] > max {
                max = prices[i];
                max_index = i;
            }
            if min_index < max_index && max - min > profit {
                profit = max - min;
            }
        }
        profit
    }
}