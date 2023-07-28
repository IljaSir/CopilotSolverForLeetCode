impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut p = pattern.chars().peekable();
        let mut s = s.split_whitespace().peekable();
        let mut map = std::collections::HashMap::new();
        while let (Some(&c), Some(&w)) = (p.peek(), s.peek()) {
            if map.insert(c, w) != map.insert(w, c) {
                return false;
            }
            p.next();
            s.next();
        }
        p.next().is_none() && s.next().is_none()
    }
}