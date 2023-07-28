impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        let mut max = 0;
        let mut result = "".to_string();
        let mut word = "".to_string();
        for c in paragraph.chars() {
            if c.is_alphabetic() {
                word.push(c.to_ascii_lowercase());
            } else {
                if !word.is_empty() {
                    if !banned.contains(&word) {
                        let count = map.entry(word.clone()).or_insert(0);
                        *count += 1;
                        if *count > max {
                            max = *count;
                            result = word.clone();
                        }
                    }
                    word = "".to_string();
                }
            }
        }
        if !word.is_empty() {
            if !banned.contains(&word) {
                let count = map.entry(word.clone()).or_insert(0);
                *count += 1;
                if *count > max {
                    max = *count;
                    result = word.clone();
                }
            }
        }
        result
    }
}