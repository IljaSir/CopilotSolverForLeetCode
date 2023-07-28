impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words: Vec<&str> = text.split_whitespace().collect();
        words[0] = words[0].to_lowercase().as_str();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        words[0] = words[0].to_uppercase().as_str();
        words.join(" ")
    }
}