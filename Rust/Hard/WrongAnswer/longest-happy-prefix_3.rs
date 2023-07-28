impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let mut s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] == s[j] {
                i += 1;
                j -= 1;
            } else {
                i = 0;
                j -= 1;
            }
        }
        String::from_utf8(s[..i].to_vec()).unwrap()
    }
}