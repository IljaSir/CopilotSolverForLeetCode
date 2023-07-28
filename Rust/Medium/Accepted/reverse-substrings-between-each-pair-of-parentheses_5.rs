impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            if c == ')' {
                let mut tmp: Vec<char> = Vec::new();
                while let Some(&x) = stack.last() {
                    if x == '(' {
                        stack.pop();
                        break;
                    }
                    tmp.push(stack.pop().unwrap());
                }
                stack.append(&mut tmp);
            } else {
                stack.push(c);
            }
        }
        stack.into_iter().collect()
    }
}