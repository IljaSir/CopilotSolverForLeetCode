impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs = costs;
        costs.sort_by(|a, b| (a[0] - a[1]).cmp(&(b[0] - b[1])));
        let n = costs.len() / 2;
        costs[..n].iter().map(|c| c[0]).sum::<i32>() + costs[n..].iter().map(|c| c[1]).sum::<i32>()
    }
}