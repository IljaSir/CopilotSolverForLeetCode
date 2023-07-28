impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut last = None;
        for word in sentence.split_whitespace() {
            if let Some(l) = last {
                if l != word.as_bytes()[0] {
                    return false;
                }
            }
            last = Some(word.as_bytes()[word.len() - 1]);
        }
        last == Some(sentence.as_bytes()[0])
    }
}