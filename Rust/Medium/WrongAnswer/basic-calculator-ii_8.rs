impl Solution {
    pub fn calculate(s: String) -> i32 {
        

        let mut stack: Vec<i32> = Vec::new();
        let mut sign = 1;
        let mut res = 0;
        let mut i = 0;
        let s = s.as_bytes();
        while i < s.len() {
            if s[i] == b' ' {
                i += 1;
                continue;
            }
            if s[i] == b'+' {
                sign = 1;
                i += 1;
            } else if s[i] == b'-' {
                sign = -1;
                i += 1;
            } else if s[i] == b'*' || s[i] == b'/' {
                let mut num = 0;
                i += 1;
                while i < s.len() && s[i] >= b'0' && s[i] <= b'9' {
                    num = num * 10 + (s[i] - b'0') as i32;
                    i += 1;
                }
                if s[i - 1] == b'*' {
                    *stack.last_mut().unwrap() *= num;
                } else {
                    *stack.last_mut().unwrap() /= num;
                }
            } else {
                let mut num = 0;
                while i < s.len() && s[i] >= b'0' && s[i] <= b'9' {
                    num = num * 10 + (s[i] - b'0') as i32;
                    i += 1;
                }
                stack.push(sign * num);
            }
        }
        for n in stack {
            res += n;
        }
        res
    }
}