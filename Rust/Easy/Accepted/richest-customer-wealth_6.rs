impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        
        accounts.iter().map(|row| row.iter().sum()).max().unwrap()
    }
}