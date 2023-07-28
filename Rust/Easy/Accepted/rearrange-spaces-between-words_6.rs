impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut count = 0;
        let mut words = vec![];
        let mut word = String::new();
        for c in text.chars() {
            if c == ' ' {
                count += 1;
                if !word.is_empty() {
                    words.push(word);
                    word = String::new();
                }
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
            for _ in 0..count {
                result.push(' ');
            }
        } else {
            let space = count / (words.len() - 1);
            let extra = count % (words.len() - 1);
            for i in 0..words.len() {
                result.push_str(&words[i]);
                if i < words.len() - 1 {
                    for _ in 0..space {
                        result.push(' ');
                    }
                }
            }
            for _ in 0..extra {
                result.push(' ');
            }
        }
        result
    }
}