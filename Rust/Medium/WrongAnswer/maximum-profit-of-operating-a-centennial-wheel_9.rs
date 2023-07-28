impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut customers = customers;
        customers.push(0);
        let mut cur = 0;
        let mut profit = 0;
        let mut max_profit = 0;
        let mut max_profit_rotations = 0;
        let mut rotations = 0;
        for c in customers {
            cur += c;
            if cur >= 4 {
                profit += 4 * boarding_cost - running_cost;
                cur -= 4;
            } else {
                profit += cur * boarding_cost - running_cost;
                cur = 0;
            }
            rotations += 1;
            if profit > max_profit {
                max_profit = profit;
                max_profit_rotations = rotations;
            }
        }
        if max_profit > 0 {
            max_profit_rotations
        } else {
            -1
        }
    }
}