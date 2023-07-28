impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut current = 0;
        for i in 1..prices.len() {
            if prices[i] == prices[i-1] - 1 {
                current += 1;
            } else {
                count += (current * (current + 1)) / 2;
                current = 0;
            }
        }
        count += (current * (current + 1)) / 2;
        count
    }
}