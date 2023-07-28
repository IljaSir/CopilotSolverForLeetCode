impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut space_count = 0;
        let mut word_count = 0;
        let mut word = String::from("");
        let mut words = Vec::new();
        for c in text.chars() {
            if c == ' ' {
                space_count += 1;
                if word.len() > 0 {
                    word_count += 1;
                    words.push(word);
                    word = String::from("");
                }
            } else {
                word.push(c);
            }
        }
        if word.len() > 0 {
            word_count += 1;
            words.push(word);
        }
        let mut result = String::new();
        if word_count == 1 {
            result.push_str(&words[0]);
            for _ in 0..space_count {
                result.push(' ');
            }
        } else {
            let space = space_count / (word_count - 1);
            for _ in 0..space {
                result.push(' ');
            }
            for i in 0..words.len() {
                result.push_str(&words[i]);
                if i < words.len() - 1 {
                    for _ in 0..space {
                        result.push(' ');
                    }
                }
            }
            for _ in 0..(space_count % (word_count - 1)) {
                result.push(' ');
            }
        }
        result
    }
}