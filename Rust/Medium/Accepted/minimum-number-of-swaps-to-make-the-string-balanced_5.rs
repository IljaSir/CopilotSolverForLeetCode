impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut result = 0;
        let mut balance = 0;
        for c in s.chars() {
            if c == '[' {
                balance += 1;
            } else {
                balance -= 1;
                if balance < 0 {
                    result += 1;
                    balance += 2;
                }
            }
        }
        result
    }
}