impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut idx = 0;
        for word in words {
            let len = word.len();
            if idx + len > s.len() || &s[idx..idx+len] != word {
                return false;
            }
            idx += len;
        }
        return true;
    }
}