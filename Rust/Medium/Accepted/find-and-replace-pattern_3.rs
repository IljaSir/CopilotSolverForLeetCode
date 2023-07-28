impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = vec![];
        let pattern: Vec<char> = pattern.chars().collect();
        for word in words {
            let mut map = std::collections::HashMap::new();
            let mut used = std::collections::HashSet::new();
            let mut ok = true;
            let word: Vec<char> = word.chars().collect();
            for (i, c) in pattern.iter().enumerate() {
                if let Some(&v) = map.get(c) {
                    if v != word[i] {
                        ok = false;
                        break;
                    }
                } else {
                    if used.contains(&word[i]) {
                        ok = false;
                        break;
                    }
                    map.insert(c, word[i]);
                    used.insert(word[i]);
                }
            }
            if ok {
                result.push(word.iter().collect());
            }
        }
        result
    }
}