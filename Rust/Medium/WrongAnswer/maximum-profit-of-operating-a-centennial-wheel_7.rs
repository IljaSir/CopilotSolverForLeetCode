impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut sum = 0;
        let mut max_profit = 0;
        let mut max_rotations = 0;
        let mut wait = 0;
        for (i, c) in customers.iter().enumerate() {
            wait += c;
            let mut board = 0;
            if wait >= 4 {
                board = 4;
                wait -= 4;
            } else {
                board = wait;
                wait = 0;
            }
            sum += board;
            let profit = sum * boarding_cost - (i + 1) as i32 * running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_rotations = (i + 1) as i32;
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
            sum += board;
            let profit = sum * boarding_cost - (customers.len() + 1) as i32 * running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_rotations = (customers.len() + 1) as i32;
            }
        }
        if max_profit <= 0 {
            return -1;
        }
        max_rotations
    }
}