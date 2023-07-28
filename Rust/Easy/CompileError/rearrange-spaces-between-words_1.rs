impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut spaces = 0;
        let mut words = Vec::new();
        let mut word = String::new();
        for c in text.chars() {
            if c == ' ' {
                if !word.is_empty() {
                    words.push(word);
                    word = String::new();
                }
                spaces += 1;
            } else {
                word.push(c);
            }
        }
        if !word.is_empty() {
            words.push(word);
        }
        let mut result = String::new();
        if words.len() == 1 {
            result.push_str(&words[0]);
            for _ in 0..spaces {
                result.push(' ');
            }
        } else {
            let space = spaces / (words.len() - 1);
            for word in words {
                result.push_str(&word);
                for _ in 0..space {
                    result.push(' ');
                }
            }
            for _ in 0..(spaces % (words.len() - 1)) {
                result.push(' ');
            }
        }
        result
    }
}