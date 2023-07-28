impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack = vec![];
        for c in s.chars() {
            match c {
                ')' => {
                    let mut tmp = vec![];
                    while let Some(c) = stack.pop() {
                        if c == '(' {
                            break;
                        }
                        tmp.push(c);
                    }
                    stack.extend(tmp);
                },
                _ => stack.push(c),
            }
        }
        stack.into_iter().collect()
    }
}