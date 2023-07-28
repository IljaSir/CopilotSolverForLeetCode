impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut min_penalty = 0;
        let mut min_penalty_hour = 0;
        for (hour, customer) in customers.chars().enumerate() {
            if customer == 'N' {
                penalty += 1;
            } else {
                penalty -= 1;
            }
            if penalty < min_penalty {
                min_penalty = penalty;
                min_penalty_hour = hour as i32 + 1;
            }
        }
        min_penalty_hour
    }
}