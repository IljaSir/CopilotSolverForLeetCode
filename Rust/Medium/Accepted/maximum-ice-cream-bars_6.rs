impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        costs.sort_unstable();
        let mut coins = coins;
        let mut ans = 0;
        for cost in costs {
            if coins < cost {
                break;
            }
            coins -= cost;
            ans += 1;
        }
        ans
    }
}