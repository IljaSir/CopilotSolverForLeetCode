impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut word_map = std::collections::HashMap::<String, i32>::new();
        let mut max_word = String::new();
        let mut max_count = 0;
        let mut word = String::new();
        for c in paragraph.chars() {
            if c.is_ascii_alphabetic() {
                word.push(c.to_ascii_lowercase());
            } else if word.len() > 0 {
                if !banned.contains(&word) {
                    let count = word_map.entry(word.clone()).or_insert(0);
                    *count += 1;
                    if *count > max_count {
                        max_count = *count;
                        max_word = word.clone();
                    }
                }
                word = String::new();
            }
        }
        if word.len() > 0 {
            if !banned.contains(&word) {
                let count = word_map.entry(word.clone()).or_insert(0);
                *count += 1;
                if *count > max_count {
                    max_count = *count;
                    max_word = word.clone();
                }
            }
        }
        max_word
    }
}