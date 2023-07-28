impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        for customer in accounts {
            let mut wealth = 0;
            for account in customer {
                wealth += account;
            }
            if wealth > max {
                max = wealth;
            }
        }
        max
    }
}