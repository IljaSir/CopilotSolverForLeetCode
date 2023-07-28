impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack: Vec<Vec<char>> = Vec::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(Vec::new());
            } else if c == ')' {
                let mut tmp = stack.pop().unwrap();
                tmp.reverse();
                if stack.is_empty() {
                    stack.push(tmp);
                } else {
                    stack.last_mut().unwrap().append(&mut tmp);
                }
            } else {
                if stack.is_empty() {
                    stack.push(vec![c]);
                } else {
                    stack.last_mut().unwrap().push(c);
                }
            }
        }
        stack.into_iter().flatten().collect()
    }
}