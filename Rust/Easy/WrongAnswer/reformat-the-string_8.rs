impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut chars: Vec<char> = s.chars().collect();
        let mut digits: Vec<char> = chars.iter().filter(|&c| c.is_digit(10)).cloned().collect();
        let mut letters: Vec<char> = chars.iter().filter(|&c| c.is_alphabetic()).cloned().collect();
        
        if (letters.len() as i32 - digits.len() as i32).abs() > 1 {
            return "".to_string();
        }
        
        let mut result: Vec<char> = Vec::new();
        let mut i = 0;
        let mut j = 0;
        
        if letters.len() > digits.len() {
            result.push(letters[i]);
            i += 1;
        } else if letters.len() < digits.len() {
            result.push(digits[j]);
            j += 1;
        }
        
        loop {
            if i >= letters.len() && j >= digits.len() {
                break;
            }
            
            if i < letters.len() {
                result.push(letters[i]);
                i += 1;
            }
            
            if j < digits.len() {
                result.push(digits[j]);
                j += 1;
            }
        }
        
        result.iter().collect()
    }
}