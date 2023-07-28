impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut penalty = 0;
        let mut min_penalty = customers.len();
        let mut min_penalty_i = 0;
        let mut penalty_i = 0;
        for (i,c) in customers.chars().enumerate() {
            if c == 'Y' {
                penalty += 1;
            } else {
                penalty -= 1;
                if penalty < min_penalty {
                    min_penalty = penalty;
                    min_penalty_i = i;
                }
            }
        }
        min_penalty_i as i32 + 1
    }
}