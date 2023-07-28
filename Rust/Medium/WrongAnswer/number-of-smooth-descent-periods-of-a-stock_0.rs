impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 1..prices.len() {
            if prices[i] - prices[i - 1] == 1 {
                count += 1;
            }
        }
        count
    }
    pub fn number_of_smooth_descent_periods(prices: Vec<i32>) -> i64 {
        let mut count = 0;
        let mut i = 0;
        while i < prices.len() {
            let mut j = i + 1;
            while j < prices.len() && prices[j] - prices[j - 1] == 1 {
                j += 1;
            }
            count += Self::get_descent_periods(prices[i..j].to_vec());
            i = j;
        }
        count
    }
}