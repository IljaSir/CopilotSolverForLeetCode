impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut words: Vec<String> = Vec::new();
        for word in s.split_whitespace() {
            words.push(word.to_string());
        }
        let mut max_word_len = 0;
        for word in &words {
            if word.len() > max_word_len {
                max_word_len = word.len();
            }
        }
        let mut result: Vec<String> = Vec::new();
        for i in 0..max_word_len {
            let mut line: String = String::new();
            for word in &words {
                if i < word.len() {
                    line.push(word.chars().nth(i).unwrap());
                } else {
                    line.push(' ');
                }
            }
            while line.ends_with(' ') {
                line.pop();
            }
            result.push(line);
        }
        result
    }
}