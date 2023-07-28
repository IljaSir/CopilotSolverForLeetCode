impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        let mut transactions = transactions;
        transactions.sort_by_key(|x| x[0]);
        let mut money = 0;
        for t in transactions {
            money += t[0] as i64;
        }
        let mut res = money;
        for t in transactions {
            money -= t[0] as i64;
            res = res.min(money + t[1] as i64);
        }
        res
    }
}