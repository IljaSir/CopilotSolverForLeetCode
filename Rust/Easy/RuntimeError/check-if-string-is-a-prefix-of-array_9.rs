impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut i = 0;
        for word in words {
            if i == s.len() {
                break;
            }
            for j in 0..word.len() {
                if word.as_bytes()[j] != s.as_bytes()[i] {
                    return false;
                }
                i += 1;
            }
        }
        return i == s.len();
    }
}