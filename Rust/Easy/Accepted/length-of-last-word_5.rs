impl Solution {
    pub fn length_of_last_word(s: String) -> i32 {
        
        let mut last_word_len = 0;
        let mut i = s.len() as i32 - 1;
        while i >= 0 && s.chars().nth(i as usize).unwrap() == ' ' {
            i -= 1;
        }
        while i >= 0 && s.chars().nth(i as usize).unwrap() != ' ' {
            last_word_len += 1;
            i -= 1;
        }
        last_word_len
    }
}