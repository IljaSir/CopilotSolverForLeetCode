impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if let Some(&top) = stack.last() {
                if top != c && top.to_ascii_uppercase() == c.to_ascii_uppercase() {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        stack.iter().collect()
    }
}