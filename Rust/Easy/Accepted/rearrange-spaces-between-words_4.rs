impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut spaces = 0;
        let mut words = vec![];
        let mut word = String::new();
        for ch in text.chars() {
            if ch == ' ' {
                spaces += 1;
                if word.len() > 0 {
                    words.push(word);
                    word = String::new();
                }
            } else {
                word.push(ch);
            }
        }
        if word.len() > 0 {
            words.push(word);
        }
        if words.len() == 1 {
            let mut s = words[0].clone();
            for _ in 0..spaces {
                s.push(' ');
            }
            return s;
        }
        let space = spaces / (words.len() - 1);
        let mut s = String::new();
        for i in 0..words.len() {
            s.push_str(&words[i]);
            if i < words.len() - 1 {
                for _ in 0..space {
                    s.push(' ');
                }
            }
        }
        for _ in 0..(spaces - space * (words.len() - 1)) {
            s.push(' ');
        }
        s
    }
}