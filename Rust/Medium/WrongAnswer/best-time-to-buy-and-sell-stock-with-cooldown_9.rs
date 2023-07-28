impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let (mut sold, mut hold, mut rest) = (0, std::i32::MIN, 0);
        for p in prices {
            sold = std::cmp::max(sold, hold + p);
            hold = std::cmp::max(hold, rest - p);
            rest = std::cmp::max(rest, sold);
        }
        sold
    }
}