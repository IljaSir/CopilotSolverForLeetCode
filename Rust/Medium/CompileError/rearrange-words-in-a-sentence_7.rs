impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words: Vec<&str> = text.split_whitespace().collect();
        words[0] = words[0].to_lowercase().as_str();
        words.sort_by_key(|word| word.len());
        let mut res = words.join(" ");
        res[0..1].make_ascii_uppercase();
        res
    }
}