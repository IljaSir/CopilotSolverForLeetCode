impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        while i < s.len() {
            if i < s.len() - 2 && s.as_bytes()[i + 2] == b'#' {
                result.push((b'a' + (s.as_bytes()[i] - b'0') * 10 + (s.as_bytes()[i + 1] - b'0') - 1) as char);
                i += 3;
            } else {
                result.push((b'a' + (s.as_bytes()[i] - b'0') - 1) as char);
                i += 1;
            }
        }
        result
    }
}