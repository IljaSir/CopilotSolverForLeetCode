impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let mut k = k as i64;
        let mut len = 0;
        for c in s.chars() {
            if c.is_alphabetic() {
                len += 1;
            } else {
                len *= c.to_digit(10).unwrap() as i64;
            }
        }
        for c in s.chars().rev() {
            k %= len;
            if k == 0 && c.is_alphabetic() {
                return c.to_string();
            }
            if c.is_alphabetic() {
                len -= 1;
            } else {
                len /= c.to_digit(10).unwrap() as i64;
            }
        }
        "".to_string()
    }
}