impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        
        let mut costs: Vec<Vec<i32>> = costs;
        costs.sort_by(|a, b| {
            let x = a[0] - a[1];
            let y = b[0] - b[1];
            x.cmp(&y)
        });
        let mut ans = 0;
        let n = costs.len() / 2;
        for i in 0..n {
            ans += costs[i][0];
        }
        for i in n..costs.len() {
            ans += costs[i][1];
        }
        ans
    }
}