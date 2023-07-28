impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        let mut transactions: Vec<(i64, i64)> = transactions.iter().map(|x| (x[0] as i64, x[1] as i64)).collect();
        transactions.sort_unstable_by(|a, b| a.0.cmp(&b.0));
        let mut money = 0;
        let mut max = 0;
        for (cost, cashback) in transactions {
            max = std::cmp::max(max, cost);
            money = std::cmp::max(money, max - cost + cashback);
        }
        money
    }
}