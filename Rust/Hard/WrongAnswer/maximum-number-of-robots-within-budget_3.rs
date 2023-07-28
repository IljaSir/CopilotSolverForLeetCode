impl Solution {
    pub fn maximum_robots(charge_times: Vec<i32>, running_costs: Vec<i32>, budget: i64) -> i32 {
        
        let n = charge_times.len();
        let mut charge_times = charge_times;
        charge_times.sort();
        let mut running_costs = running_costs;
        running_costs.sort();
        let mut prefix_sum = vec![0; n + 1];
        for i in 0..n {
            prefix_sum[i + 1] = prefix_sum[i] + running_costs[i];
        }
        let mut ans = 0;
        for i in 0..n {
            let mut l = i;
            let mut r = n;
            while l < r {
                let mid = (l + r + 1) / 2;
                if charge_times[i] as i64 + prefix_sum[mid] as i64 - prefix_sum[i] as i64 <= budget {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans = ans.max(l - i + 1);
        }
        ans as i32
    }
}