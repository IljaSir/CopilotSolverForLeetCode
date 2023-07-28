impl Solution {
    pub fn longest_ideal_string(s: String, k: i32) -> i32 {
        
        let mut max = 0;
        let mut l = 0;
        let mut r = 0;
        let mut stack = Vec::new();
        let mut s = s.as_bytes();
        loop {
            while r < s.len() {
                if stack.is_empty() || s[stack[stack.len() - 1]] < s[r] {
                    stack.push(r);
                    r += 1;
                } else {
                    if s[stack[stack.len() - 1]] - s[r] <= k as u8 {
                        max = max.max(stack.len() as i32 + r as i32 - l as i32);
                        stack.push(r);
                        r += 1;
                    } else {
                        while !stack.is_empty() && s[stack[stack.len() - 1]] - s[r] > k as u8 {
                            l = stack.pop().unwrap() + 1;
                        }
                        if stack.is_empty() {
                            break;
                        } else {
                            max = max.max(stack.len() as i32 + r as i32 - l as i32);
                            stack.push(r);
                            r += 1;
                        }
                    }
                }
            }
            if stack.is_empty() {
                break;
            } else {
                while !stack.is_empty() {
                    l = stack.pop().unwrap() + 1;
                }
            }
        }
        max
    }
}