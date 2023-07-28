impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut spaces = 0;
        let mut words = Vec::new();
        let mut word = String::new();
        for c in text.chars() {
            if c == ' ' {
                spaces += 1;
                if word.len() > 0 {
                    words.push(word);
                    word = String::new();
                }
            } else {
                word.push(c);
            }
        }
        if word.len() > 0 {
            words.push(word);
        }
        if words.len() == 1 {
            return words[0] + &" ".repeat(spaces);
        }
        let mut spaces_between_words = spaces / (words.len() - 1);
        let mut spaces_at_end = spaces - spaces_between_words * (words.len() - 1);
        let mut result = String::new();
        for i in 0..words.len() {
            result += &words[i];
            if i < words.len() - 1 {
                result += &" ".repeat(spaces_between_words);
            }
        }
        result += &" ".repeat(spaces_at_end);
        result
    }
}