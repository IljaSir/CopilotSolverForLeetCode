impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let n = customers.len();
        let mut penalty = 0;
        let mut min_penalty = n as i32;
        let mut min_time = 0;
        for i in 0..n {
            if customers.chars().nth(i).unwrap() == 'Y' {
                penalty += 1;
            } else {
                penalty -= 1;
            }
            if penalty < min_penalty {
                min_penalty = penalty;
                min_time = i as i32 + 1;
            }
        }
        min_time
    }
}