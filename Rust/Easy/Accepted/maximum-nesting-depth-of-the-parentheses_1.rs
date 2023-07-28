impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for c in s.chars() {
            if c == '(' {
                count += 1;
                if count > max {
                    max = count;
                }
            } else if c == ')' {
                count -= 1;
            }
        }
        max
    }
}