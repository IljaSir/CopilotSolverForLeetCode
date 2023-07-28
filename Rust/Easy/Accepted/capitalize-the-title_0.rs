impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        title.split_whitespace().map(|s| {
            if s.len() < 3 {
                s.to_lowercase()
            } else {
                format!("{}{}", &s[..1].to_uppercase(), &s[1..].to_lowercase())
            }
        }).collect::<Vec<String>>().join(" ")
    }
}