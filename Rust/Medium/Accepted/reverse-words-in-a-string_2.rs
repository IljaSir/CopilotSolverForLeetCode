impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let mut words = Vec::new();
        let mut word = String::new();
        for c in s.chars() {
            if c == ' ' {
                if !word.is_empty() {
                    words.push(word.clone());
                    word.clear();
                }
            } else {
                word.push(c);
            }
        }
        if !word.is_empty() {
            words.push(word);
        }
        words.reverse();
        words.join(" ")
    }
}