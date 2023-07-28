impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut max = 0;
        for price in prices.iter() {
            if *price < min {
                min = *price;
            } else if *price - min > max {
                max = *price - min;
            }
        }
        max
    }
}