impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut stack = Vec::new();
        let mut cnt = 0;
        for ch in s.chars() {
            if ch == ')' {
                if stack.pop().is_none() {
                    cnt += 1;
                }
                if stack.pop().is_none() {
                    cnt += 1;
                }
            } else {
                stack.push('(');
            }
        }
        cnt + stack.len() * 2
    }
}