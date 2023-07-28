impl Solution {
    pub fn count_segments(s: String) -> i32 {
        
        let mut count = 0;
        let mut is_word = false;
        for c in s.chars() {
            if c == ' ' {
                if is_word {
                    count += 1;
                    is_word = false;
                }
            } else {
                is_word = true;
            }
        }
        if is_word {
            count += 1;
        }
        count
    }
}