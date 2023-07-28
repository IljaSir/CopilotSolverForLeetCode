impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut letters: Vec<char> = Vec::new();
        let mut digits: Vec<char> = Vec::new();
        for c in s.chars() {
            if c.is_digit(10) {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }
        if (letters.len() as i32 - digits.len() as i32).abs() > 1 {
            return "".to_string();
        }
        let mut result = String::new();
        let mut i = 0;
        let mut j = 0;
        let mut flag = false;
        if letters.len() < digits.len() {
            flag = true;
        }
        loop {
            if i == letters.len() && j == digits.len() {
                break;
            }
            if flag {
                if i < letters.len() {
                    result.push(letters[i]);
                    i += 1;
                }
                if j < digits.len() {
                    result.push(digits[j]);
                    j += 1;
                }
            } else {
                if j < digits.len() {
                    result.push(digits[j]);
                    j += 1;
                }
                if i < letters.len() {
                    result.push(letters[i]);
                    i += 1;
                }
            }
        }
        result
    }
}