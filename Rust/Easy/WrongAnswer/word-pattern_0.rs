impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let pattern = pattern.chars().collect::<Vec<char>>();
        let s = s.split(' ').collect::<Vec<&str>>();
        if pattern.len() != s.len() {
            return false;
        }
        let mut map = std::collections::HashMap::new();
        let mut set = std::collections::HashSet::new();
        for i in 0..pattern.len() {
            if !set.contains(&pattern[i]) {
                if map.contains_key(&pattern[i]) {
                    return false;
                }
                map.insert(pattern[i], s[i]);
                set.insert(pattern[i]);
            } else {
                if map[&pattern[i]] != s[i] {
                    return false;
                }
            }
        }
        true
    }
}