impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut result: Vec<char> = Vec::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(result);
                result = Vec::new();
            } else if c == ')' {
                result.reverse();
                let mut tmp = stack.pop().unwrap();
                tmp.append(&mut result);
                result = tmp;
            } else {
                result.push(c);
            }
        }
        result.into_iter().collect()
    }
}