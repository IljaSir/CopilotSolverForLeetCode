impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let s = s.as_bytes();
        let mut stack = vec![0];
        let mut i = 0;
        while i < s.len() {
            let mut j = i;
            let mut num = 0;
            while j < s.len() {
                num = num * 10 + s[j] as i32 - b'0' as i32;
                if stack.len() > 1 && num == stack[stack.len() - 1] - 1 {
                    stack.pop();
                    if stack.is_empty() {
                        return true;
                    }
                } else if stack.len() == 1 && num < stack[0] {
                    stack.push(num);
                }
                j += 1;
            }
            i += 1;
            stack.clear();
            stack.push(0);
        }
        false
    }
}