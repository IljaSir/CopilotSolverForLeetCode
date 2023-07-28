impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by_key(|x| x[0] - x[1]);
        let mut sum = 0;
        for i in 0..costs.len() {
            if i < costs.len() / 2 {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        sum
    }
}