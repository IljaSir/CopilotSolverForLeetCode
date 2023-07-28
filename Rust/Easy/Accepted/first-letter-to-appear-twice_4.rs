impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            if let Some(x) = map.get(&c) {
                return c;
            } else {
                map.insert(c, 1);
            }
        }
        ' '
    }
}