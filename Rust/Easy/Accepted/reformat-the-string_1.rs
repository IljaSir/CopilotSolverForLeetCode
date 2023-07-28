impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut digits = Vec::new();
        let mut letters = Vec::new();
        for c in s.chars() {
            if c.is_digit(10) {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }
        if (digits.len() as i32 - letters.len() as i32).abs() > 1 {
            return "".to_string();
        }
        let mut res = String::new();
        if digits.len() > letters.len() {
            for i in 0..digits.len() {
                res.push(digits[i]);
                if i < letters.len() {
                    res.push(letters[i]);
                }
            }
        } else {
            for i in 0..letters.len() {
                res.push(letters[i]);
                if i < digits.len() {
                    res.push(digits[i]);
                }
            }
        }
        res
    }
}