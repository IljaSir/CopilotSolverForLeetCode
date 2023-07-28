impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        costs.sort();
        let mut ans = 0;
        for c in costs {
            if coins >= c {
                ans += 1;
            } else {
                break;
            }
        }
        ans
    }
}