impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        
        let mut max_wealth = 0;
        for account in accounts {
            let mut wealth = 0;
            for money in account {
                wealth += money;
            }
            if wealth > max_wealth {
                max_wealth = wealth;
            }
        }
        max_wealth
    }
}