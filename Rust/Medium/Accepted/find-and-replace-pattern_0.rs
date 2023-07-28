impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = Vec::new();
        for word in words {
            if Self::is_match(&word, &pattern) {
                result.push(word);
            }
        }
        result
    }
    fn is_match(word: &str, pattern: &str) -> bool {
        let mut map = std::collections::HashMap::new();
        let mut used = std::collections::HashSet::new();
        for (w, p) in word.chars().zip(pattern.chars()) {
            if !map.contains_key(&p) {
                if used.contains(&w) {
                    return false;
                }
                map.insert(p, w);
                used.insert(w);
            } else {
                if *map.get(&p).unwrap() != w {
                    return false;
                }
            }
        }
        true
    }
}