impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut result = String::new();
        let mut is_first = true;
        for c in title.chars() {
            if is_first {
                result.push(c.to_ascii_uppercase());
                is_first = false;
            } else {
                result.push(c.to_ascii_lowercase());
            }
            if c == ' ' {
                is_first = true;
            }
        }
        result
    }
}