impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut chars = Vec::new();
        let mut digits = Vec::new();
        for c in s.chars() {
            if c.is_ascii_digit() {
                digits.push(c);
            } else {
                chars.push(c);
            }
        }
        if (chars.len() as i32 - digits.len() as i32).abs() > 1 {
            return String::new();
        }
        let mut result = String::new();
        if chars.len() >= digits.len() {
            for i in 0..digits.len() {
                result.push(chars[i]);
                result.push(digits[i]);
            }
            if chars.len() > digits.len() {
                result.push(chars[chars.len() - 1]);
            }
        } else {
            for i in 0..chars.len() {
                result.push(digits[i]);
                result.push(chars[i]);
            }
            result.push(digits[digits.len() - 1]);
        }
        result
    }
}