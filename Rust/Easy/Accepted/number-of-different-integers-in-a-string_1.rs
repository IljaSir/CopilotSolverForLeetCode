impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut s = String::new();
        for c in word.chars() {
            if c.is_digit(10) {
                s.push(c);
            } else {
                s.push(' ');
            }
        }
        let mut set = std::collections::HashSet::new();
        for i in s.split_whitespace() {
            let mut s = i.to_string();
            while s.starts_with('0') {
                s.remove(0);
            }
            if s.is_empty() {
                s.push('0');
            }
            set.insert(s);
        }
        set.len() as i32
    }
}