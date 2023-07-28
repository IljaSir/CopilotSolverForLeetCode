impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut words: Vec<String> = vec![];
        let mut max_len = 0;
        for word in s.split(' ') {
            max_len = max_len.max(word.len());
            words.push(word.to_string());
        }
        let mut res = vec![];
        for i in 0..max_len {
            let mut s = String::new();
            for word in &words {
                if i < word.len() {
                    s.push(word.chars().nth(i).unwrap());
                } else {
                    s.push(' ');
                }
            }
            res.push(s.trim_end().to_string());
        }
        res
    }
}