impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut spaces = 0;
        let mut words = 0;
        let mut word = String::new();
        let mut res = String::new();
        for c in text.chars() {
            if c == ' ' {
                spaces += 1;
                if !word.is_empty() {
                    words += 1;
                    res.push_str(&word);
                    res.push(' ');
                    word.clear();
                }
            } else {
                word.push(c);
            }
        }
        if !word.is_empty() {
            words += 1;
            res.push_str(&word);
        }
        if words == 1 {
            res.push_str(&" ".repeat(spaces));
        } else {
            let space = spaces / (words - 1);
            let mut tmp = String::new();
            for _ in 0..space {
                tmp.push(' ');
            }
            res = res.replace(" ", &tmp);
            res.push_str(&" ".repeat(spaces - space * (words - 1)));
        }
        res
    }
}