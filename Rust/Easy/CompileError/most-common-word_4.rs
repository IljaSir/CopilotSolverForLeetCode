impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut word_count: HashMap<String, i32> = HashMap::new();
        let mut word = String::new();
        let mut max_count = 0;
        let mut max_word = String::new();
        for c in paragraph.chars() {
            if c.is_alphabetic() {
                word.push(c.to_ascii_lowercase());
            } else if !word.is_empty() {
                if !banned.contains(&word) {
                    let count = word_count.entry(word.clone()).or_insert(0);
                    *count += 1;
                    if *count > max_count {
                        max_count = *count;
                        max_word = word.clone();
                    }
                }
                word.clear();
            }
        }
        if !word.is_empty() {
            if !banned.contains(&word) {
                let count = word_count.entry(word.clone()).or_insert(0);
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