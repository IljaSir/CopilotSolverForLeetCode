impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut pattern = pattern.chars().collect::<Vec<char>>();
        let mut s = s.split_whitespace().collect::<Vec<&str>>();
        let mut hash = std::collections::HashMap::new();
        if pattern.len() != s.len() {
            return false;
        }
        for i in 0..pattern.len() {
            if hash.contains_key(&pattern[i]) {
                if hash[&pattern[i]] != s[i] {
                    return false;
                }
            } else {
                if hash.contains_value(&s[i]) {
                    return false;
                }
                hash.insert(pattern[i], s[i]);
            }
        }
        true
    }
}