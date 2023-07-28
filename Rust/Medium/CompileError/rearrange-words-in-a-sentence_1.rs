impl Solution {
    pub fn arrange_words(text: String) -> String {
        
        let mut words = text.split_whitespace().collect::<Vec<&str>>();
        words[0] = words[0].to_lowercase().as_str();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut result = words.join(" ");
        let mut chars = result.chars().collect::<Vec<char>>();
        chars[0] = chars[0].to_uppercase().nth(0).unwrap();
        result = chars.into_iter().collect();
        result
    }
}