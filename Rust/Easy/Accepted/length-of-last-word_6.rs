impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let s = s.trim();
        let mut i = s.len();
        while i > 0 {
            if s.as_bytes()[i-1] == b' ' {
                break;
            }
            i -= 1;
        }
        (s.len() - i) as i32
    }
}