impl Solution {
    pub fn is_circular_sentence(sentence: String) -> bool {
        
        let mut sentence = sentence.as_bytes();
        let mut i = 0;
        let mut j = 0;
        let mut n = 0;
        while i < sentence.len() {
            if sentence[i] == b' ' {
                if n == 0 {
                    return false;
                }
                n = 0;
                j = i + 1;
            } else {
                n += 1;
                if n == 1 {
                    if sentence[j] != sentence[i] {
                        return false;
                    }
                }
            }
            i += 1;
        }
        true
    }
}