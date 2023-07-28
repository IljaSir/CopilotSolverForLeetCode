impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let mut k = k as u64;
        let mut len = 0;
        for c in s.chars() {
            if c.is_digit(10) {
                len *= c.to_digit(10).unwrap() as u64;
            } else {
                len += 1;
            }
        }
        for c in s.chars().rev() {
            k %= len;
            if k == 0 && c.is_alphabetic() {
                return c.to_string();
            }
            if c.is_digit(10) {
                len /= c.to_digit(10).unwrap() as u64;
            } else {
                len -= 1;
            }
        }
        "".to_string()
    }
}