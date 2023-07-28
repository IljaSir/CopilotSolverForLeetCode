impl Solution {
    pub fn reverse_words(s: String) -> String {
        
        let mut buf = String::new();
        let mut word = Vec::new();
        for c in s.chars() {
            if c == ' ' {
                word.reverse();
                buf.push_str(&word.iter().collect::<String>());
                buf.push(' ');
                word.clear();
            } else {
                word.push(c);
            }
        }
        word.reverse();
        buf.push_str(&word.iter().collect::<String>());
        buf
    }
}