impl Solution {
    pub fn remove_stars(s: String) -> String {
        
        let mut stack: Vec<char> = vec![];
        for c in s.chars() {
            if c == '*' {
                if !stack.is_empty() {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        stack.iter().collect()
    }
}