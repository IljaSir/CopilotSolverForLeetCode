impl Solution {
    pub fn print_vertically(s: String) -> Vec<String> {
        
        let mut words: Vec<String> = s.split(' ').map(|w| w.to_string()).collect();
        let mut max_len = 0;
        for word in &words {
            if word.len() > max_len {
                max_len = word.len();
            }
        }
        let mut res: Vec<String> = Vec::new();
        for i in 0..max_len {
            let mut word: String = String::new();
            for j in 0..words.len() {
                if i < words[j].len() {
                    word.push(words[j].chars().nth(i).unwrap());
                } else {
                    word.push(' ');
                }
            }
            res.push(word);
        }
        for i in 0..res.len() {
            let mut chars: Vec<char> = res[i].chars().collect();
            while chars.len() > 0 && chars[chars.len() - 1] == ' ' {
                chars.pop();
            }
            res[i] = chars.iter().collect();
        }
        res
    }
}