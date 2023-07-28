impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let words: Vec<&str> = s.split(" ").collect();
        let max_len = words.iter().map(|w| w.len()).max().unwrap();
        let mut result = vec![];
        for i in 0..max_len {
            let mut line = String::new();
            for word in &words {
                let ch = word.chars().nth(i).unwrap_or(' ');
                line.push(ch);
            }
            line = line.trim_end().to_string();
            result.push(line);
        }
        result
    }
}