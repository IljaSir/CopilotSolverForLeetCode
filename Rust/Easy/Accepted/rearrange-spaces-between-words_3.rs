impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut words = Vec::new();
        let mut spaces = 0;
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
        let n = words.len();
        if n == 1 {
            let mut res = words[0].clone();
            for _ in 0..spaces {
                res.push(' ');
            }
            return res;
        }
        let space = spaces / (n - 1);
        let extra = spaces % (n - 1);
        let mut res = String::new();
        for i in 0..n - 1 {
            res.push_str(&words[i]);
            for _ in 0..space {
                res.push(' ');
            }
        }
        res.push_str(&words[n - 1]);
        for _ in 0..extra {
            res.push(' ');
        }
        res
    }
}