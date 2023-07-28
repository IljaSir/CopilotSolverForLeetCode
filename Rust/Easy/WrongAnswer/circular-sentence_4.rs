impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut prev = ' ';
        for c in sentence.chars() {
            if c == ' ' {
                if prev != ' ' {
                    return false;
                }
            } else {
                if prev == ' ' {
                    prev = c;
                } else if prev.to_ascii_lowercase() != c.to_ascii_lowercase() {
                    return false;
                }
            }
        }
        prev != ' '
    }
}