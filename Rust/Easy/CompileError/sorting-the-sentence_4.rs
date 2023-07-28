impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words: Vec<String> = s.split_whitespace().map(|w| w.to_string()).collect();
        words.sort_by_key(|w| w.pop().unwrap());
        words.join(" ")
    }
}