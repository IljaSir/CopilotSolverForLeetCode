impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let mut profit = 0;
        let mut buy = -1;
        for i in 0..prices.len() {
            if buy == -1 {
                if i == prices.len() - 1 {
                    break;
                } else if prices[i] < prices[i + 1] {
                    buy = prices[i];
                }
            } else {
                if i == prices.len() - 1 || prices[i] > prices[i + 1] {
                    profit += prices[i] - buy;
                    buy = -1;
                }
            }
        }
        profit
    }
}