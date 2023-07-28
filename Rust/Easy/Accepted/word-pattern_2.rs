impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut pattern = pattern.chars().collect::<Vec<char>>();
        let mut s = s.split_whitespace().collect::<Vec<&str>>();
        if pattern.len() != s.len() {
            return false;
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..pattern.len() {
            if map.contains_key(&pattern[i]) {
                if map[&pattern[i]] != s[i] {
                    return false;
                }
            } else {
                if map.values().any(|v| *v == s[i]) {
                    return false;
                }
                map.insert(pattern[i], s[i]);
            }
        }
        true
    }
}