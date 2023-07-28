impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut max_profit = 0;
        let mut max_rotate = 0;
        let mut waiting = 0;
        let mut profit = 0;
        let mut rotate = 0;
        for c in customers {
            waiting += c;
            let board = std::cmp::min(waiting, 4);
            waiting -= board;
            profit += board * boarding_cost - running_cost;
            rotate += 1;
            if profit > max_profit {
                max_profit = profit;
                max_rotate = rotate;
            }
        }
        while waiting > 0 {
            let board = std::cmp::min(waiting, 4);
            waiting -= board;
            profit += board * boarding_cost - running_cost;
            rotate += 1;
            if profit > max_profit {
                max_profit = profit;
                max_rotate = rotate;
            }
        }
        if max_profit > 0 {
            max_rotate
        } else {
            -1
        }
    }
}