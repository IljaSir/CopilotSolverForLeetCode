impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            if let Some(&last) = stack.last() {
                if last != c && last.to_ascii_lowercase() == c.to_ascii_lowercase() {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        stack.into_iter().collect()
    }
}