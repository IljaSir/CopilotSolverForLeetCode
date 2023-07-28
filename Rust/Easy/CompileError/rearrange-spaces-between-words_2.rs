impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut words = Vec::new();
        let mut spaces = 0;
        let mut word = String::new();
        for c in text.chars() {
            if c == ' ' {
                spaces += 1;
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
        if words.len() == 1 {
            return words[0] + &" ".repeat(spaces);
        }
        let spaces_between = spaces / (words.len() - 1);
        let extra_spaces = spaces % (words.len() - 1);
        let mut result = String::new();
        for word in words {
            result.push_str(&word);
            result.push(' ');
            if spaces_between > 0 {
                result.push_str(&" ".repeat(spaces_between));
            }
        }
        result.pop();
        result.push_str(&" ".repeat(extra_spaces));
        result
    }
}