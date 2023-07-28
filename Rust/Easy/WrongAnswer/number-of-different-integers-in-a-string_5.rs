impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        let mut num = String::new();
        for c in word.chars() {
            if c.is_digit(10) {
                if c == '0' && num.is_empty() {
                    continue;
                }
                num.push(c);
            } else {
                if !num.is_empty() {
                    set.insert(num);
                    num = String::new();
                }
            }
        }
        if !num.is_empty() {
            set.insert(num);
        }
        set.len() as i32
    }
}