impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let mut profit = 0;
        let mut i = 0;
        let mut buy = 0;
        let mut sell = 0;
        let mut k = k;
        while i < prices.len() {
            while i < prices.len() - 1 && prices[i] >= prices[i + 1] {
                i += 1;
            }
            buy = prices[i];
            while i < prices.len() - 1 && prices[i] <= prices[i + 1] {
                i += 1;
            }
            sell = prices[i];
            profit += sell - buy;
            k -= 1;
            if k == 0 {
                break;
            }
            i += 1;
        }
        profit
    }
}