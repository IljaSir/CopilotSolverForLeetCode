impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        
        let morse: Vec<String> = vec![
            ".-".to_string(),
            "-...".to_string(),
            "-.-.".to_string(),
            "-..".to_string(),
            ".".to_string(),
            "..-.".to_string(),
            "--.".to_string(),
            "....".to_string(),
            "..".to_string(),
            ".---".to_string(),
            "-.-".to_string(),
            ".-..".to_string(),
            "--".to_string(),
            "-.".to_string(),
            "---".to_string(),
            ".--.".to_string(),
            "--.-".to_string(),
            ".-.".to_string(),
            "...".to_string(),
            "-".to_string(),
            "..-".to_string(),
            "...-".to_string(),
            ".--".to_string(),
            "-..-".to_string(),
            "-.--".to_string(),
            "--..".to_string(),
        ];
        let mut res: Vec<String> = vec![];
        for w in words {
            let mut s: String = "".to_string();
            for c in w.chars() {
                s.push_str(morse.get((c as u8 - 'a' as u8) as usize).unwrap());
            }
            if !res.contains(&s) {
                res.push(s);
            }
        }
        res.len() as i32
    }
}