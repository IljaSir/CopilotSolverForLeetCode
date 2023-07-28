impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut res = String::new();
        let mut first = true;
        for c in title.chars() {
            if c == ' ' {
                first = true;
                res.push(c);
            } else if first {
                res.push(c.to_ascii_uppercase());
                first = false;
            } else {
                res.push(c.to_ascii_lowercase());
            }
        }
        res
    }
}