impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut ret = String::new();
        for c in s.chars() {
            if c == ')' {
                let mut tmp = String::new();
                while let Some(x) = stack.pop() {
                    if x == '(' {
                        break;
                    } else {
                        tmp.push(x);
                    }
                }
                stack.extend(tmp.chars());
            } else {
                stack.push(c);
            }
        }
        stack.into_iter().collect()
    }
}