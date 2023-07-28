impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut costs = costs;
        costs.sort();
        let mut count = 0;
        let mut money = coins;
        for cost in costs {
            if money >= cost {
                money -= cost;
                count += 1;
            }
        }
        count
    }
}