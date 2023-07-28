impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let mut k = k;
        let mut size = 0;
        for c in s.chars() {
            if c.is_numeric() {
                size *= c.to_digit(10).unwrap() as i64;
            } else {
                size += 1;
            }
        }

        for c in s.chars().rev() {
            k %= size;
            if k == 0 && c.is_alphabetic() {
                return c.to_string();
            }
            if c.is_numeric() {
                size /= c.to_digit(10).unwrap() as i64;
            } else {
                size -= 1;
            }
        }
        "".to_string()
    }
}