impl Solution {
    pub fn maximum_robots(charge_times: Vec<i32>, running_costs: Vec<i32>, budget: i64) -> i32 {
        
        let n = charge_times.len();
        let mut charge_times = charge_times;
        charge_times.sort();
        let mut running_costs = running_costs;
        running_costs.sort();
        let mut total = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = n - 1;
        loop {
            if i < n && j >= 0 && charge_times[i] + running_costs[j] <= budget - total {
                total += charge_times[i] + running_costs[j];
                i += 1;
                j -= 1;
                max += 1;
            } else {
                break;
            }
        }
        max
    }
}