impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match stack.last() {
                Some(&x) if x != c && x.to_ascii_lowercase() == c.to_ascii_lowercase() => {
                    stack.pop();
                }
                _ => stack.push(c),
            }
        }
        stack.into_iter().collect()
    }
}