impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut periods = 0;
        let mut prev = prices[0];
        for price in prices {
            if price == prev {
                continue;
            }
            if price == prev - 1 {
                periods += 1;
            } else {
                periods += (price - prev) as i64;
            }
            prev = price;
        }
        periods
    }
}