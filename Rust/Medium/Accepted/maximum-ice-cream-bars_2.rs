impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        let mut coins = coins;
        let mut count = 0;
        costs.sort();
        for i in 0..costs.len() {
            if coins >= costs[i] {
                coins -= costs[i];
                count += 1;
            }
        }
        count
    }
}