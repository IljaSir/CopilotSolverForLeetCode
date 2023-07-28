impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut chars = sentence.chars();
        let mut first = chars.next().unwrap();
        let mut last = first;
        for c in chars {
            if c.is_whitespace() {
                first = chars.next().unwrap();
                continue;
            }
            last = c;
        }
        last.to_ascii_lowercase() == first.to_ascii_lowercase()
    }
}