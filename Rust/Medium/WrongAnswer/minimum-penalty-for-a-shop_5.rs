impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut min_penalty = 0;
        let mut min_penalty_hour = 0;
        let mut open = 0;
        for (i, c) in customers.chars().enumerate() {
            if c == 'Y' {
                penalty += 1;
                open += 1;
            } else {
                open -= 1;
                if open < 0 {
                    penalty += 1;
                    open = 0;
                }
            }
            if penalty < min_penalty {
                min_penalty = penalty;
                min_penalty_hour = i + 1;
            }
        }
        min_penalty_hour as i32
    }
}