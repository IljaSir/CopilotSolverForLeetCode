impl Solution {
    pub fn maximum_robots(charge_times: Vec<i32>, running_costs: Vec<i32>, budget: i64) -> i32 {
        
        let mut charge_times = charge_times;
        charge_times.sort_unstable();
        let mut running_costs = running_costs;
        running_costs.sort_unstable();
        let mut left = 0;
        let mut right = charge_times.len() as i32;
        while left < right {
            let mid = (left + right + 1) / 2;
            let mut cost = 0;
            for i in 0..mid as usize {
                cost += charge_times[i as usize] as i64 + mid as i64 * running_costs[i as usize] as i64;
            }
            if cost <= budget {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        left
    }
}