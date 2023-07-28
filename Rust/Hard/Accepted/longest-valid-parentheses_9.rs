impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let s = s.as_bytes();
        let mut stack = vec![];
        let mut max = 0;
        let mut left = -1;
        for (i, &c) in s.iter().enumerate() {
            if c == b'(' {
                stack.push(i as i32);
            } else {
                if let Some(&j) = stack.last() {
                    stack.pop();
                    if let Some(&k) = stack.last() {
                        max = max.max(i as i32 - k);
                    } else {
                        max = max.max(i as i32 - left);
                    }
                } else {
                    left = i as i32;
                }
            }
        }
        max as i32
    }
}