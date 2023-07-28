impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut s = s;
        for w in words {
            if s.starts_with(&w) {
                s = s[w.len()..].to_string();
            } else {
                return false;
            }
        }
        s.is_empty()
    }
}