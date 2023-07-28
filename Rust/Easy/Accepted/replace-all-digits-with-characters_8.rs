impl Solution {
    pub fn replace_digits(s: String) -> String {
        
        let mut result = String::new();
        let mut chars = s.chars();
        match chars.next() {
            Some(c) => result.push(c),
            None => return result,
        };
        for c in chars {
            if c.is_digit(10) {
                let prev = result.chars().last().unwrap();
                result.push((prev as u8 + c.to_digit(10).unwrap() as u8) as char);
            } else {
                result.push(c);
            }
        }
        result
    }
}