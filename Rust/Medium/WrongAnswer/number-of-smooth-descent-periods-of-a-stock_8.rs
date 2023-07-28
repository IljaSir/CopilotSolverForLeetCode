impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut result = 0;
        let mut last = prices[0];
        let mut streak = 0;
        for &price in prices.iter().skip(1) {
            if price == last {
                streak = 0;
            } else if price == last + 1 {
                streak += 1;
                result += streak;
            } else {
                streak = 0;
            }
            last = price;
        }
        result
    }
}