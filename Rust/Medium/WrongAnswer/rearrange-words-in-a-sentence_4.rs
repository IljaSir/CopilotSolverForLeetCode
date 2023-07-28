impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words: Vec<String> = text.split(" ").map(|w| w.to_string()).collect();
        words[0] = words[0].to_lowercase();
        words.sort_by_key(|w| w.len());
        words[0] = words[0].to_uppercase();
        words.join(" ")
    }
}