impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut first = sentence.chars().next().unwrap();
        let mut last = sentence.chars().last().unwrap();
        if first.is_uppercase() {
            first = first.to_lowercase().next().unwrap();
        }
        if last.is_uppercase() {
            last = last.to_lowercase().next().unwrap();
        }
        last == first
    }
}