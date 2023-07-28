impl Solution {
    pub fn capitalize_title(title: String) -> String {
        
        let mut words: Vec<&str> = title.split(" ").collect();
        for i in 0..words.len() {
            let mut word: &str = words[i];
            let mut chars: Vec<char> = word.chars().collect();
            if chars.len() > 2 {
                chars[0] = chars[0].to_uppercase().nth(0).unwrap();
                chars[1..].iter_mut().for_each(|c| *c = c.to_lowercase().nth(0).unwrap());
            } else {
                chars.iter_mut().for_each(|c| *c = c.to_lowercase().nth(0).unwrap());
            }
            words[i] = chars.iter().collect::<String>().as_str();
        }
        words.join(" ")
    }
}