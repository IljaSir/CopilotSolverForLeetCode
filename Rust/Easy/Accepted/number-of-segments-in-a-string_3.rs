impl Solution {
    pub fn count_segments(s: String) -> i32 {
        
        let mut count = 0;
        let mut is_word = false;
        for c in s.chars() {
            if c == ' ' {
                is_word = false;
            } else {
                if !is_word {
                    count += 1;
                    is_word = true;
                }
            }
        }
        count
    }
}