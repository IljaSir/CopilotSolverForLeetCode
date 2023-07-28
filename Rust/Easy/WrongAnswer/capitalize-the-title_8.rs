impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        title.split_whitespace().map(|word| {
            let mut chars = word.chars();
            match chars.next() {
                Some(c) => c.to_uppercase().to_string() + chars.as_str(),
                None => String::new(),
            }
        }).collect::<Vec<String>>().join(" ")
    }
}