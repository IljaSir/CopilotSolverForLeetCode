impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by_key(|c| c[0] - c[1]);
        let mut sum = 0;
        for i in 0..costs.len()/2 {
            sum += costs[i][0] + costs[costs.len() - i - 1][1];
        }
        sum
    }
}