impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut res = String::new();
        let mut chars = s.chars();
        while let Some(c) = chars.next() {
            res.push(c);
            if let Some(n) = chars.next() {
                res.push((c as u8 + n as u8 - '0' as u8) as char);
            }
        }
        res
    }
}