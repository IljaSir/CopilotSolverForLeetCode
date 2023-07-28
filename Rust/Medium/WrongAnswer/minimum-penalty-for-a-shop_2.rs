impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut max_penalty = 0;
        let mut best_closing_time = 0;
        for (i, c) in customers.chars().enumerate() {
            if c == 'N' {
                penalty += 1;
            } else {
                penalty -= 1;
            }
            if penalty > max_penalty {
                max_penalty = penalty;
                best_closing_time = i as i32 + 1;
            }
        }
        best_closing_time
    }
}