impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut total = 0;
        let mut max = 0;
        let mut wait = 0;
        let mut ans = -1;
        for (i, &c) in customers.iter().enumerate() {
            wait += c;
            let mut board = 0;
            if wait >= 4 {
                board = 4;
                wait -= 4;
            } else {
                board = wait;
                wait = 0;
            }
            total += board * boarding_cost - running_cost;
            if total > max {
                max = total;
                ans = i as i32 + 1;
            }
        }
        while wait > 0 {
            let mut board = 0;
            if wait >= 4 {
                board = 4;
                wait -= 4;
            } else {
                board = wait;
                wait = 0;
            }
            total += board * boarding_cost - running_cost;
            if total > max {
                max = total;
                ans = customers.len() as i32;
            }
            ans += 1;
        }
        ans
    }
}