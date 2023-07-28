impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words = text.split_whitespace().collect::<Vec<_>>();
        words[0] = &words[0].to_lowercase();
        words.sort_by_key(|w| w.len());
        words[0] = &words[0].to_uppercase();
        words.join(" ")
    }
}