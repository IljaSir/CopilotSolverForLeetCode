impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut res = "".to_string();
        for word in title.split(" ") {
            if word.len() == 1 {
                res.push_str(&word.to_lowercase());
            } else if word.len() == 2 {
                res.push_str(&word.to_lowercase());
            } else {
                res.push_str(&word[0..1].to_uppercase());
                res.push_str(&word[1..].to_lowercase());
            }
            res.push_str(" ");
        }
        res[0..res.len()-1].to_string()
    }
}