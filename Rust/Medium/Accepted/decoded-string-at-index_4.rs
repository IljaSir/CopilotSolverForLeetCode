impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let mut k = k as i64;
        let mut n = 0;
        for c in s.chars() {
            if c.is_alphabetic() {
                n += 1;
            } else {
                n *= c.to_digit(10).unwrap() as i64;
            }
        }
        let mut k = k - 1;
        let mut n = n - 1;
        for c in s.chars().rev() {
            if c.is_alphabetic() {
                if k == n {
                    return c.to_string();
                }
                n -= 1;
            } else {
                let d = c.to_digit(10).unwrap() as i64;
                n /= d;
                k %= n + 1;
            }
        }
        "".to_string()
    }
}