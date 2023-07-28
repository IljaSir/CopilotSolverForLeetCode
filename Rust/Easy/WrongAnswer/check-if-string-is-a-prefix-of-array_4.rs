impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut s = s;
        for i in 0..words.len() {
            if s.starts_with(&words[i]) {
                s = s[words[i].len()..].to_string();
            } else {
                return false;
            }
        }
        s.len() == 0
    }
}