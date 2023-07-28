impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut cost = costs;
        cost.sort();
        let mut count = 0;
        for i in 0..cost.len() {
            if cost[i] <= coins {
                count += 1;
            } else {
                break;
            }
        }
        count
    }
}