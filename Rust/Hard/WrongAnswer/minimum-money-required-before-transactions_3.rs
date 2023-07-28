impl Solution {
    pub fn minimum_money(transactions: Vec<Vec<i32>>) -> i64 {
        
        transactions.iter().map(|x| x[0] as i64).sum()
    }
}