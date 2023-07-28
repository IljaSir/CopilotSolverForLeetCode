impl Solution {
    pub fn max_depth(s: String) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for c in s.chars() {
            if c == '(' {
                cur += 1;
                if cur > max {
                    max = cur;
                }
            } else if c == ')' {
                cur -= 1;
            }
        }
        max
    }
}