impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words = text.to_lowercase().split_whitespace().collect::<Vec<&str>>();
        words[0] = words[0].get(0..1).unwrap().to_uppercase().as_str();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        words.join(" ")
    }
}