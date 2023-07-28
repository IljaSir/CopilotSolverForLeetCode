impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut digits = Vec::new();
        let mut letters = Vec::new();
        for c in s {
            if c.is_ascii_digit() {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }
        if (digits.len() as i32 - letters.len() as i32).abs() > 1 {
            return "".to_owned();
        }
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while i < digits.len() || j < letters.len() {
            if digits.len() > letters.len() {
                result.push(digits[i]);
                i += 1;
            } else if digits.len() < letters.len() {
                result.push(letters[j]);
                j += 1;
            } else {
                result.push(digits[i]);
                result.push(letters[j]);
                i += 1;
                j += 1;
            }
        }
        unsafe { String::from_utf8_unchecked(result) }
    }
}