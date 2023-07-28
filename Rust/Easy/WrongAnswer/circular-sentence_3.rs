impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut chars = sentence.chars();
        let mut prev = chars.next().unwrap();
        for c in chars {
            if c.is_ascii_uppercase() && prev.is_ascii_lowercase() {
                return false;
            }
            if c.is_ascii_lowercase() && prev.is_ascii_uppercase() {
                return false;
            }
            prev = c;
        }
        if sentence.chars().count() > 1 {
            let first = sentence.chars().next().unwrap();
            let last = sentence.chars().last().unwrap();
            if first.is_ascii_uppercase() && last.is_ascii_lowercase() {
                return false;
            }
            if first.is_ascii_lowercase() && last.is_ascii_uppercase() {
                return false;
            }
        }
        true
    }
}