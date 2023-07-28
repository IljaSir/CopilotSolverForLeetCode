impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        use std::collections::HashMap;
        let mut word_map = HashMap::new();
        let mut word = String::new();
        for c in paragraph.chars() {
            if c.is_alphabetic() {
                word.push(c.to_ascii_lowercase());
            } else if !word.is_empty() {
                *word_map.entry(word).or_insert(0) += 1;
                word.clear();
            }
        }
        if !word.is_empty() {
            *word_map.entry(word).or_insert(0) += 1;
        }
        let mut max_count = 0;
        let mut max_word = String::new();
        for (word, count) in word_map {
            if !banned.contains(&word) && count > max_count {
                max_word = word;
                max_count = count;
            }
        }
        max_word
    }
}