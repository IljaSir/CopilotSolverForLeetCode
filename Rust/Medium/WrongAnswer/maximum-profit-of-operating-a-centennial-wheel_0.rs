impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut max_profit = 0;
        let mut max_rotations = 0;
        let mut waiting = 0;
        let mut profit = 0;
        for i in 0..customers.len() {
            waiting += customers[i];
            let boarding = if waiting > 4 { 4 } else { waiting };
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_rotations = i as i32 + 1;
            }
        }
        let mut rotations = max_rotations;
        while waiting > 0 {
            let boarding = if waiting > 4 { 4 } else { waiting };
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
            rotations += 1;
            if profit > max_profit {
                max_profit = profit;
                max_rotations = rotations;
            }
        }
        if max_profit > 0 {
            max_rotations
        } else {
            -1
        }
    }
}