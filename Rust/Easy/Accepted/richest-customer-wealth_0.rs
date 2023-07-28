impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        for i in 0..accounts.len() {
            let mut sum = 0;
            for j in 0..accounts[i].len() {
                sum += accounts[i][j];
            }
            if sum > max {
                max = sum;
            }
        }
        max
    }
}