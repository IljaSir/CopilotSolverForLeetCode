impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut max_profit = 0;
        let mut max_profit_times = -1;
        let mut waiting = 0;
        let mut profit = 0;
        for i in 0..customers.len() {
            waiting += customers[i];
            let mut board = waiting.min(4);
            waiting -= board;
            profit += board * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_profit_times = i as i32 + 1;
            }
        }
        let mut i = customers.len() as i32;
        while waiting > 0 {
            let mut board = waiting.min(4);
            waiting -= board;
            profit += board * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_profit_times = i + 1;
            }
            i += 1;
        }
        if max_profit_times == 0 {
            -1
        } else {
            max_profit_times
        }
    }
}