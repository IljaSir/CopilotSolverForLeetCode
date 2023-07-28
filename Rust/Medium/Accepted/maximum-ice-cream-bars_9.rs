impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        costs.sort();
        let mut res = 0;
        let mut cost = 0;
        for i in 0..costs.len() {
            cost += costs[i];
            if cost > coins {
                break;
            }
            res += 1;
        }
        res
    }
}