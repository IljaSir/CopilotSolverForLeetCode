impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        for account in accounts {
            let mut wealth = 0;
            for money in account {
                wealth += money;
            }
            if wealth > result {
                result = wealth;
            }
        }
        result
    }
}