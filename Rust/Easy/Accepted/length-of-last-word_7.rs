impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut len = 0;
        let mut isWord = false;
        for c in s.chars().rev() {
            if c == ' ' {
                if isWord {
                    break;
                }
            } else {
                isWord = true;
                len += 1;
            }
        }
        len
    }
}