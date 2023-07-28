impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut length = 0;
        let mut last = false;
        for c in s.chars().rev() {
            if c == ' ' {
                if last {
                    break;
                }
            } else {
                last = true;
                length += 1;
            }
        }
        length
    }
}