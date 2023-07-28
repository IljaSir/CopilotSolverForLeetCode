impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        let mut money = 0;
        let mut cost = 0;
        for t in transactions {
            money += t[1] as i64;
            cost += t[0] as i64;
        }
        cost - money
    }
}