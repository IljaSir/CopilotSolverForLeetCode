impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut s = s;
        for word in words {
            if s.starts_with(&word) {
                s = s[word.len()..].to_string();
            } else {
                return false;
            }
        }
        s == ""
    }
}