impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut s = s.as_bytes();
        for i in 1..s.len() {
            if i % 2 == 1 {
                s[i] = (s[i - 1] + s[i] - b'0') as u8;
            }
        }
        unsafe { String::from_utf8_unchecked(s.to_vec()) }
    }
}