impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let mut profit = 0;
        let mut buy = 0;
        let mut sell = 0;
        let mut i = 1;
        while i < prices.len() {
            while i < prices.len() && prices[i] <= prices[i - 1] {
                i += 1;
            }
            buy = prices[i - 1];
            while i < prices.len() && prices[i] >= prices[i - 1] {
                i += 1;
            }
            sell = prices[i - 1];
            profit += sell - buy;
        }
        profit
    }
}