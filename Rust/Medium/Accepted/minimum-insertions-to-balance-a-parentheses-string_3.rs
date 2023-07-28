impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut ans = 0;
        let mut stack = 0;
        let mut i = 0;
        while i < s.len() {
            if s.as_bytes()[i] == b'(' {
                stack += 1;
            } else {
                if i + 1 < s.len() && s.as_bytes()[i + 1] == b')' {
                    i += 1;
                } else {
                    ans += 1;
                }
                if stack > 0 {
                    stack -= 1;
                } else {
                    ans += 1;
                }
            }
            i += 1;
        }
        ans + stack * 2
    }
}