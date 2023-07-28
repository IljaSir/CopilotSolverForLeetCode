impl Solution {
    pub fn min_operations_max_profit(customers: Vec<i32>, boarding_cost: i32, running_cost: i32) -> i32 {
        
        let mut max_profit = 0;
        let mut max_rotation = 0;
        let mut rotation = 0;
        let mut waiting = 0;
        let mut profit = 0;
        for c in customers {
            waiting += c;
            rotation += 1;
            let boarding = waiting.min(4);
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_rotation = rotation;
            }
        }
        while waiting > 0 {
            rotation += 1;
            let boarding = waiting.min(4);
            waiting -= boarding;
            profit += boarding * boarding_cost - running_cost;
            if profit > max_profit {
                max_profit = profit;
                max_rotation = rotation;
            }
        }
        if max_profit > 0 {
            max_rotation
        } else {
            -1
        }
    }
}