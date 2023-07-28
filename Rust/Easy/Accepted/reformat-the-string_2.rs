impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut digits = Vec::new();
        let mut letters = Vec::new();
        for c in s.chars() {
            if c.is_ascii_digit() {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }
        if (digits.len() as i32 - letters.len() as i32).abs() > 1 {
            return String::new();
        }
        let mut result = String::new();
        if digits.len() > letters.len() {
            for i in 0..letters.len() {
                result.push(digits[i]);
                result.push(letters[i]);
            }
            result.push(digits[letters.len()]);
        } else {
            for i in 0..digits.len() {
                result.push(letters[i]);
                result.push(digits[i]);
            }
            if letters.len() > digits.len() {
                result.push(letters[letters.len() - 1]);
            }
        }
        result
    }
}