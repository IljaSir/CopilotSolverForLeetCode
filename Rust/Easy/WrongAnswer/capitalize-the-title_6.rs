impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut result = String::new();
        let mut is_first_letter = true;
        for c in title.chars() {
            if is_first_letter {
                result.push(c.to_ascii_uppercase());
                is_first_letter = false;
            } else {
                result.push(c.to_ascii_lowercase());
            }
            if c == ' ' {
                is_first_letter = true;
            }
        }
        result
    }
}