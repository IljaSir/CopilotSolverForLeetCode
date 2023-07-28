impl Solution {
    pub fn maximum_robots(charge_times: Vec<i32>, running_costs: Vec<i32>, budget: i64) -> i32 {
        
        let mut charge_times = charge_times;
        let mut running_costs = running_costs;
        let n = charge_times.len();
        charge_times.sort_unstable();
        running_costs.sort_unstable();
        let mut l = 0;
        let mut r = n;
        while l < r {
            let mid = (l + r + 1) / 2;
            let mut sum = 0;
            for i in 0..mid {
                sum += charge_times[i] as i64 + running_costs[i] as i64 * mid as i64;
            }
            if sum <= budget {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        l as i32
    }
}