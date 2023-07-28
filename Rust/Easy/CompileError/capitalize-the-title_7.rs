impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut title = title;
        let mut first = true;
        for c in title.as_bytes_mut() {
            if first {
                *c = c.to_ascii_uppercase();
                first = false;
            } else if *c == ' ' as u8 {
                first = true;
            } else {
                *c = c.to_ascii_lowercase();
            }
        }
        title
    }
}