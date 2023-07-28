impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut s = n.as_bytes().to_vec();
        let mut i = 0;
        if s[0] == b'-' {
            i = 1;
            while i < s.len() && s[i] - b'0' <= x as u8 {
                i += 1;
            }
        } else {
            while i < s.len() && s[i] - b'0' >= x as u8 {
                i += 1;
            }
        }
        s.insert(i, x as u8 + b'0');
        String::from_utf8(s).unwrap()
    }
}