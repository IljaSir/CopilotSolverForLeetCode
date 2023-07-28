impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
        }
        for (c, count) in map {
            if count > 1 {
                return c;
            }
        }
        ' '
    }
}