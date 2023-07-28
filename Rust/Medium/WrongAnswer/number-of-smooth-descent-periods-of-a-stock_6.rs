impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 1;
        while j < prices.len() {
            if prices[j] - prices[i] == 1 {
                j += 1;
            } else {
                count += (j - i) as i64 * ((j - i) as i64 - 1) / 2;
                i = j;
                j += 1;
            }
        }
        count += (j - i) as i64 * ((j - i) as i64 - 1) / 2;
        count
    }
}