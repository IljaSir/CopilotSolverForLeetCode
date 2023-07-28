impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        
        let mut chars = text.chars().collect::<Vec<char>>();
        let mut spaces = 0;
        let mut words = 0;
        let mut i = 0;
        while i < chars.len() {
            if chars[i] == ' ' {
                spaces += 1;
            } else {
                words += 1;
                while i < chars.len() && chars[i] != ' ' {
                    i += 1;
                }
            }
            i += 1;
        }
        if words == 1 {
            let mut res = String::new();
            res.push_str(&text.trim());
            res.push_str(&" ".repeat(spaces));
            return res;
        }
        let spaces_per_word = spaces / (words - 1);
        let extra_spaces = spaces % (words - 1);
        let mut res = String::new();
        let mut j = 0;
        while j < chars.len() {
            if chars[j] == ' ' {
                j += 1;
            } else {
                res.push(chars[j]);
                while j < chars.len() && chars[j] != ' ' {
                    j += 1;
                }
                if j < chars.len() {
                    res.push_str(&" ".repeat(spaces_per_word));
                }
            }
        }
        res.push_str(&" ".repeat(extra_spaces));
        res
    }
}