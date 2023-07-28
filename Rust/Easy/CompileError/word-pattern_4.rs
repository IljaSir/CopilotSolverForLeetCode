impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut set = std::collections::HashSet::new();
        let words: Vec<String> = s.split(' ').map(|s| s.to_string()).collect();
        if pattern.len() != words.len() {
            return false;
        }
        for (i, c) in pattern.chars().enumerate() {
            let word = &words[i];
            if map.contains_key(&c) {
                if map.get(&c).unwrap() != word {
                    return false;
                }
            } else {
                if set.contains(word) {
                    return false;
                }
                map.insert(c, word);
                set.insert(word);
            }
        }
        true
    }
}