impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut n = n.into_bytes();
        let is_negative = n[0] == b'-';
        let mut i = if is_negative { 1 } else { 0 };
        while i < n.len() && (is_negative ^ (n[i] - b'0' as u8) < x as u8) {
            i += 1;
        }
        n.insert(i, b'0' + x as u8);
        String::from_utf8(n).unwrap()
    }
}