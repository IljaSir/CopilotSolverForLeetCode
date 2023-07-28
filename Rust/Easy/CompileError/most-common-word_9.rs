impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut map = HashMap::new();
        let mut word = String::new();
        let mut max = 0;
        let mut answer = String::new();
        for c in paragraph.chars() {
            if c.is_ascii_alphabetic() {
                word.push(c.to_ascii_lowercase());
            } else if !word.is_empty() {
                if !banned.contains(&word) {
                    let count = map.entry(word.clone()).or_insert(0);
                    *count += 1;
                    if *count > max {
                        max = *count;
                        answer = word.clone();
                    }
                }
                word.clear();
            }
        }
        if !word.is_empty() {
            if !banned.contains(&word) {
                let count = map.entry(word.clone()).or_insert(0);
                *count += 1;
                if *count > max {
                    max = *count;
                    answer = word.clone();
                }
            }
        }
        answer
    }
}