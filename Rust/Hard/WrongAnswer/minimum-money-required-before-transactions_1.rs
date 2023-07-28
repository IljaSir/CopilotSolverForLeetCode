impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        let mut sum = 0;
        for t in transactions.iter() {
            sum += t[0] as i64;
        }
        sum
    }
}