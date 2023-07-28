impl Solution {
    pub fn is_prefix_string(s: String, words: Vec<String>) -> bool {
        
        let mut ss = s;
        let mut i = 0;
        while i < words.len() {
            if ss.starts_with(&words[i]) {
                ss = ss[words[i].len()..].to_string();
                i += 1;
            } else {
                return false;
            }
        }
        ss == ""
    }
}