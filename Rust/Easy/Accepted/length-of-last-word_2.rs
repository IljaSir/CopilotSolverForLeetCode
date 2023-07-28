impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut len = 0;
        let mut last = 0;
        for c in s.chars() {
            if c == ' ' {
                if len != 0 {
                    last = len;
                    len = 0;
                }
            } else {
                len += 1;
            }
        }
        if len != 0 {
            len
        } else {
            last
        }
    }
}