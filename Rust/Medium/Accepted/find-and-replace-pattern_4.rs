impl Solution {
    pub fn find_and_replace_pattern(words: Vec<String>, pattern: String) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut pattern_vec = Vec::new();
        for c in pattern.chars() {
            pattern_vec.push(c);
        }
        for word in &words {
            let mut word_vec = Vec::new();
            for c in word.chars() {
                word_vec.push(c);
            }
            if Solution::is_pattern(&word_vec, &pattern_vec) {
                result.push(word.clone());
            }
        }
        result
    }
    
    pub fn is_pattern(word: &Vec<char>, pattern: &Vec<char>) -> bool {
        let mut map = std::collections::HashMap::new();
        for i in 0..word.len() {
            let c = word[i];
            match map.get(&c) {
                Some(&p) => {
                    if p != pattern[i] {
                        return false;
                    }
                },
                None => {
                    map.insert(c, pattern[i]);
                }
            }
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..word.len() {
            let c = pattern[i];
            match map.get(&c) {
                Some(&p) => {
                    if p != word[i] {
                        return false;
                    }
                },
                None => {
                    map.insert(c, word[i]);
                }
            }
        }
        true
    }
}