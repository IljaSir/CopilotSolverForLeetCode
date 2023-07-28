impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            let count = map.entry(c).or_insert(0);
            *count += 1;
            if *count == 2 {
                return c;
            }
        }
        '0'
    }
}