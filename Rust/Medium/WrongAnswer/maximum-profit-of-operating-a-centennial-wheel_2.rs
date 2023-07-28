impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut cur = 0;
        let mut max = 0;
        let mut ans = -1;
        let mut i = 0;
        while i < customers.len() || cur > 0 {
            if i < customers.len() {
                cur += customers[i];
            }
            let take = std::cmp::min(cur, 4);
            cur -= take;
            let profit = take * boarding_cost - running_cost;
            max += profit;
            if max > ans {
                ans = max;
                ans += 1;
            }
            i += 1;
        }
        ans
    }
}