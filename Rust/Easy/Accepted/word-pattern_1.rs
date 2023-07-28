impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let pattern = pattern.chars().collect::<Vec<char>>();
        let s = s.split(' ').collect::<Vec<&str>>();
        if pattern.len() != s.len() {
            return false;
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..pattern.len() {
            if let Some(v) = map.get(&pattern[i]) {
                if *v != s[i] {
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