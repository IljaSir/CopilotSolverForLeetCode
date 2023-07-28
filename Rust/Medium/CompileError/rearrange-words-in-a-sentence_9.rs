impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut text = text;
        text = text.to_lowercase();
        let mut words: Vec<&str> = text.split(" ").collect();
        words.sort_by_key(|w| w.len());
        words[0] = words[0].chars().next().unwrap().to_uppercase().to_string() + &words[0][1..];
        words.join(" ")
    }
}