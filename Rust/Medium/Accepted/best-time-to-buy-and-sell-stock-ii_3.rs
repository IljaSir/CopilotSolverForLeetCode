impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let mut profit = 0;
        let mut i = 0;
        while i < prices.len() - 1 {
            if prices[i] < prices[i + 1] {
                profit += prices[i + 1] - prices[i];
            }
            i += 1;
        }
        return profit;
    }
}