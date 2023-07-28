impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut cur = 0;
        let mut profit = 0;
        let mut max_profit = 0;
        let mut max_profit_round = 0;
        let mut round = 0;
        for c in customers {
            cur += c;
            round += 1;
            let mut board = 0;
            if cur >= 4 {
                board = 4;
                cur -= 4;
            } else {
                board = cur;
                cur = 0;
            }
            profit = profit + board * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_profit_round = round;
            }
        }
        while cur > 0 {
            round += 1;
            let mut board = 0;
            if cur >= 4 {
                board = 4;
                cur -= 4;
            } else {
                board = cur;
                cur = 0;
            }
            profit = profit + board * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_profit_round = round;
            }
        }
        if max_profit > 0 {
            max_profit_round
        } else {
            -1
        }
    }
}