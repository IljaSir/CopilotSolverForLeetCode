impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let mut k = k as i64;
        let mut n = 0i64;
        for c in s.chars() {
            if c.is_digit(10) {
                n *= c.to_digit(10).unwrap() as i64;
            } else {
                n += 1;
            }
        }
        for c in s.chars().rev() {
            k %= n;
            if k == 0 && c.is_alphabetic() {
                return c.to_string();
            }
            if c.is_digit(10) {
                n /= c.to_digit(10).unwrap() as i64;
            } else {
                n -= 1;
            }
        }
        "".to_string()
    }
}