impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut res = ' ';
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            if map.contains_key(&c) {
                res = c;
                break;
            } else {
                map.insert(c, 1);
            }
        }
        res
    }
}