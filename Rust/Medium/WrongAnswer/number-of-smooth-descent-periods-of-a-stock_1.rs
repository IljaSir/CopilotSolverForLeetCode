impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut periods = 0;
        let mut streak = 0;
        for i in 1..prices.len() {
            if prices[i] < prices[i - 1] {
                streak += 1;
            } else {
                periods += streak * (streak + 1) / 2;
                streak = 0;
            }
        }
        periods += streak * (streak + 1) / 2;
        periods
    }
}