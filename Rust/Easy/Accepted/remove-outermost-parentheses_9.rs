impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut ans = String::new();
        let mut idx = 0;
        for ch in s.chars() {
            if ch == '(' {
                stack.push(idx);
            } else {
                let start = stack.pop().unwrap();
                if stack.is_empty() {
                    ans.push_str(&s[start+1..idx]);
                }
            }
            idx += 1;
        }
        ans
    }
}