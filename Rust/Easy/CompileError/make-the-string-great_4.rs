impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack = Vec::new();
        for ch in s.chars() {
            if let Some(&last) = stack.last() {
                if last != ch && last.to_ascii_lowercase() == ch.to_ascii_lowercase() {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        stack.into_iter().collect()
    }
}