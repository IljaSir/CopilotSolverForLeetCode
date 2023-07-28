impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let k = k as usize;
        let mut len = 0;
        let mut i = 0;
        let mut ch = ' ';
        for c in s.chars() {
            if c.is_ascii_digit() {
                len *= c.to_digit(10).unwrap() as usize;
            } else {
                len += 1;
            }
        }
        for c in s.chars().rev() {
            i += 1;
            if c.is_ascii_digit() {
                len /= c.to_digit(10).unwrap() as usize;
                k %= len;
            } else {
                if k == len || k == 0 {
                    ch = c;
                    break;
                }
                len -= 1;
            }
        }
        ch.to_string()
    }
}