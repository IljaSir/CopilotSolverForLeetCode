impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut last_word = String::new();
        let mut found = false;
        for c in s.chars().rev() {
            if c == ' ' {
                if found {
                    break;
                }
            } else {
                found = true;
                last_word.push(c);
            }
        }
        last_word.len() as i32
    }
}