impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut waiting = 0;
        let mut profit = 0;
        let mut max_profit = 0;
        let mut max_profit_rotations = 0;
        for (i, c) in customers.into_iter().enumerate() {
            waiting += c;
            let boarding = std::cmp::min(waiting, 4);
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_profit_rotations = i as i32 + 1;
            }
        }
        let mut rotations = customers.len() as i32;
        while waiting > 0 {
            let boarding = std::cmp::min(waiting, 4);
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
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