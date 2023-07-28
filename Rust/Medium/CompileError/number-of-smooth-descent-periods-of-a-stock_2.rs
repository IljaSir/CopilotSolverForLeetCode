impl Solution {
    pub fn get_descent_periods(prices: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut i = 0;
        while i < prices.len() - 1 {
            if prices[i] - prices[i + 1] == 1 {
                let mut j = i + 2;
                while j < prices.len() && prices[j - 1] - prices[j] == 1 {
                    j += 1;
                }
                count += j - i as i64;
                i = j - 1;
            }
            i += 1;
        }
        count
    }
}