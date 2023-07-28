impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let s = s.into_bytes();
        let mut i = 1;
        while i < s.len() {
            let mut j = 0;
            while i + j < s.len() && s[j] == s[i + j] {
                j += 1;
            }
            if i + j == s.len() {
                return String::from_utf8(s[..i].to_vec()).unwrap();
            }
            i += 1;
        }
        String::new()
    }
}