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
        if digits.len() < letters.len() {
            std::mem::swap(&mut digits, &mut letters);
        }
        if digits.len() - letters.len() > 1 {
            return String::new();
        }
        let mut res = String::new();
        let mut i = 0;
        while i < letters.len() {
            res.push(digits[i]);
            res.push(letters[i]);
            i += 1;
        }
        if i < digits.len() {
            res.push(digits[i]);
        }
        res
    }
}