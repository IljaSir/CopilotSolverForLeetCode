impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut pattern = pattern.chars().collect::<Vec<char>>();
        let mut s = s.split_whitespace().collect::<Vec<&str>>();
        let mut map = std::collections::HashMap::new();
        if pattern.len() != s.len() {
            return false;
        }
        for i in 0..pattern.len() {
            if !map.contains_key(&pattern[i]) {
                if map.values().any(|&v| v == s[i]) {
                    return false;
                }
                map.insert(pattern[i], s[i]);
            } else {
                if map[&pattern[i]] != s[i] {
                    return false;
                }
            }
        }
        true
    }
}