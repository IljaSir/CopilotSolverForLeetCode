impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut prev = prices[0];
        for p in prices.iter() {
            if *p < prev {
                count += 1;
            } else {
                count += *p - prev;
            }
            prev = *p;
        }
        count
    }
}