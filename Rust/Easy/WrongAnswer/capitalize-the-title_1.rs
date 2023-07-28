impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut result = String::new();
        let mut first = true;
        for c in title.chars() {
            if first {
                result.push(c.to_ascii_uppercase());
                first = false;
            } else if c == ' ' {
                result.push(c);
                first = true;
            } else {
                result.push(c.to_ascii_lowercase());
            }
        }
        result
    }
}