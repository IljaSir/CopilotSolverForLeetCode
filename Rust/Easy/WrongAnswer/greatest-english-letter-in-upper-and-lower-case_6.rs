impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut max = 0;
        let mut max_char = ' ';
        for c in s.chars() {
            let val = c as u8;
            if val >= 65 && val <= 90 {
                if val > max {
                    max = val;
                    max_char = c;
                }
            } else if val >= 97 && val <= 122 {
                if val - 32 > max {
                    max = val - 32;
                    max_char = c.to_ascii_uppercase();
                }
            }
        }
        if max == 0 {
            return String::new();
        }
        return max_char.to_string();
    }
}