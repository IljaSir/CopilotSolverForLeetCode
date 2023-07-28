impl Solution {
    pub fn can_be_valid(s: String, locked: String) -> bool {
        
        let n = s.len();
        let mut stack = Vec::new();
        for i in 0..n {
            if s.as_bytes()[i] == b'(' {
                stack.push(i);
            } else if stack.len() > 0 && locked.as_bytes()[stack[stack.len() - 1]] == b'0' {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        let mut l = 0;
        let mut r = 0;
        for i in 0..stack.len() {
            if s.as_bytes()[stack[i]] == b'(' {
                l += 1;
            } else {
                r += 1;
            }
        }
        l == r
    }
}