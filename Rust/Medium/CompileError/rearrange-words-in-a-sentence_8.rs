impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words = text.split_whitespace().collect::<Vec<_>>();
        words[0] = words[0].to_lowercase().as_str();
        words.sort_by_key(|&s| s.len());
        let mut result = words.join(" ");
        result[0..1].make_ascii_uppercase();
        result
    }
}