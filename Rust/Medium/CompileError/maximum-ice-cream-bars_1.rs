impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        costs.sort();
        let mut res = 0;
        for cost in costs {
            if coins < cost {
                break;
            }
            res += 1;
            coins -= cost;
        }
        res
    }
}