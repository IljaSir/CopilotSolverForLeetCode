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
        for s in s.split(' ') {
            if s.len() > 0 {
                set.insert(s.trim_start_matches('0'));
            }
        }
        set.len() as i32
    }
}