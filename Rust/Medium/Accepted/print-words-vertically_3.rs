impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut result: Vec<String> = Vec::new();
        let words: Vec<&str> = s.split_whitespace().collect();
        let max_len: usize = words.iter().map(|w| w.len()).max().unwrap();
        for i in 0..max_len {
            let mut line: Vec<char> = Vec::new();
            for word in &words {
                if i < word.len() {
                    line.push(word.chars().nth(i).unwrap());
                } else {
                    line.push(' ');
                }
            }
            while let Some(c) = line.pop() {
                if c != ' ' {
                    line.push(c);
                    break;
                }
            }
            result.push(line.into_iter().collect());
        }
        result
    }
}