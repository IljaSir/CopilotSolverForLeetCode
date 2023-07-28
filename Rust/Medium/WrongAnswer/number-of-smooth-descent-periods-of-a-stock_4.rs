impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut result: i64 = 0;
        let mut count: i64 = 0;
        for i in 0..prices.len()-1 {
            if prices[i] - prices[i+1] == 1 {
                count += 1;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }
        result += count * (count + 1) / 2;
        result
    }
}