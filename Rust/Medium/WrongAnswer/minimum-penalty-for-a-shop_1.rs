impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut min_penalty = customers.len() as i32;
        let mut closing_time = 0;
        for (i, c) in customers.chars().enumerate() {
            if c == 'Y' {
                penalty += 1;
            } else {
                penalty -= 1;
            }
            if penalty < min_penalty {
                min_penalty = penalty;
                closing_time = i as i32;
            }
        }
        closing_time
    }
}