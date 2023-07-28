impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut ret = String::new();
        let mut i = 0;
        while i < s.len() {
            let c = s.as_bytes()[i];
            if i + 2 < s.len() && s.as_bytes()[i + 2] == b'#' {
                let n = (c - b'0') * 10 + (s.as_bytes()[i + 1] - b'0');
                ret.push((n + b'a' - 1) as char);
                i += 3;
            } else {
                ret.push((c + b'a' - b'1') as char);
                i += 1;
            }
        }
        ret
    }
}