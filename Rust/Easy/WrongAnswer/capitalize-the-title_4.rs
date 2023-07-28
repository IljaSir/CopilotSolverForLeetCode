impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut res = String::new();
        for (i, c) in title.chars().enumerate() {
            if i == 0 || title.as_bytes()[i-1] == b' ' {
                res.push(c.to_ascii_uppercase());
            } else {
                res.push(c.to_ascii_lowercase());
            }
        }
        res
    }
}