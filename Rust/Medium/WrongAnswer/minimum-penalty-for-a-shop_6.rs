impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut min_penalty = 0;
        let mut min_penalty_hour = 0;
        let mut open = 0;
        for (i, c) in customers.chars().enumerate() {
            penalty += if c == 'Y' { 1 } else { 0 };
            penalty += if open == 0 { 1 } else { 0 };
            if penalty < min_penalty {
                min_penalty = penalty;
                min_penalty_hour = i;
            }
            open += if c == 'Y' { 1 } else { -1 };
        }
        min_penalty_hour as i32
    }
}