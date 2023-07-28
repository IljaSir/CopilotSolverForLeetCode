impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by_key(|cost| cost[0] - cost[1]);
        costs.iter().take(costs.len() / 2).map(|cost| cost[0]).sum::<i32>() + costs.iter().skip(costs.len() / 2).map(|cost| cost[1]).sum::<i32>()
    }
}