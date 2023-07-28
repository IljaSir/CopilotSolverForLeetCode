impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        for c in customers.chars() {
            if c == 'N' {
                penalty += 1;
            }
        }
        let mut min_penalty = penalty;
        let mut min_time = customers.len() as i32;
        for (i, c) in customers.chars().enumerate() {
            if c == 'N' {
                penalty += 1;
            } else {
                penalty -= 1;
            }
            if penalty < min_penalty {
                min_penalty = penalty;
                min_time = i as i32;
            }
        }
        min_time
    }
}