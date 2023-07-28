impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut result = String::new();
        let mut chars = s.chars();
        let mut prev = chars.next().unwrap();
        result.push(prev);
        for c in chars {
            if c.is_ascii_digit() {
                let offset = c.to_digit(10).unwrap() as u8;
                let new_char = (prev as u8 + offset) as char;
                result.push(new_char);
                prev = new_char;
            } else {
                result.push(c);
                prev = c;
            }
        }
        result
    }
}