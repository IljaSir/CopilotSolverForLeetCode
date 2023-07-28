impl Solution {
    pub fn closest_cost(base_costs: Vec<i32>, topping_costs: Vec<i32>, target: i32) -> i32 {
        
        let mut res = i32::MAX;
        for base in base_costs {
            let mut cur = base;
            let mut best = base;
            let mut diff = i32::MAX;
            let mut topping = 0;
            while topping < topping_costs.len() {
                cur += topping_costs[topping];
                let cur_diff = (cur - target).abs();
                if cur_diff < diff {
                    diff = cur_diff;
                    best = cur;
                }
                topping += 1;
            }
            if best == target {
                return target;
            }
            if (best - target).abs() < (res - target).abs() {
                res = best;
            }
        }
        res
    }
}