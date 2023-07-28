impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut ret = String::new();
        let mut chars = s.chars().peekable();
        while let Some(c) = chars.next() {
            ret.push(c);
            if let Some(d) = chars.peek() {
                let d = d.to_digit(10).unwrap() as u8;
                ret.push((c as u8 + d) as char);
                chars.next();
            }
        }
        ret
    }
}