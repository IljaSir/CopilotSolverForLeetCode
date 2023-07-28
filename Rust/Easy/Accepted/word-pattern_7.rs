impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut s = s.split(' ');
        let mut map = std::collections::HashMap::new();
        for c in pattern.chars() {
            if let Some(word) = s.next() {
                if map.contains_key(&c) {
                    if map[&c] != word {
                        return false;
                    }
                } else {
                    if map.values().any(|&v| v == word) {
                        return false;
                    }
                    map.insert(c, word);
                }
            } else {
                return false;
            }
        }
        s.next().is_none()
    }
}