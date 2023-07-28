impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut max = 0;
        let mut depth = 0;
        for c in s.chars() {
            if c == '(' {
                depth += 1;
                if depth > max {
                    max = depth;
                }
            } else if c == ')' {
                depth -= 1;
            }
        }
        max
    }
}