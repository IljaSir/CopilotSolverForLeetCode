impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by(|a, b| (a[0] - a[1]).cmp(&(b[0] - b[1])));
        let mut ans = 0;
        for i in 0..costs.len() / 2 {
            ans += costs[i][0] + costs[i + costs.len() / 2][1];
        }
        ans
    }
}