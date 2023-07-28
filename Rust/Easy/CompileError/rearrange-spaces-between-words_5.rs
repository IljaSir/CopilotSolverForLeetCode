impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut words = Vec::new();
        let mut spaces = 0;
        let mut word = String::new();
        for c in text.chars() {
            if c == ' ' {
                if word.len() > 0 {
                    words.push(word);
                    word = String::new();
                }
                spaces += 1;
            } else {
                word.push(c);
            }
        }
        if word.len() > 0 {
            words.push(word);
        }
        if words.len() == 1 {
            return words[0] + " ".repeat(spaces).as_str();
        }
        let mut result = String::new();
        let mut i = 0;
        let mut space = " ".repeat(spaces / (words.len() - 1)).as_str();
        while i < words.len() - 1 {
            result += words[i].as_str();
            result += space;
            i += 1;
        }
        result += words[i].as_str();
        result += " ".repeat(spaces % (words.len() - 1)).as_str();
        result
    }
}