impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by_key(|c| c[0] - c[1]);
        let mut sum = 0;
        for i in 0..costs.len() {
            sum += if i < costs.len() / 2 { costs[i][0] } else { costs[i][1] };
        }
        sum
    }
}