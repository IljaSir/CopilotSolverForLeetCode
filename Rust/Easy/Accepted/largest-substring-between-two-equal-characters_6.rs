impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut max_len = -1;
        let mut i = 0;
        while i < s.len() {
            let mut j = s.len() - 1;
            while j > i {
                if s.chars().nth(i).unwrap() == s.chars().nth(j).unwrap() {
                    let len = (j - i - 1) as i32;
                    if max_len < len {
                        max_len = len;
                    }
                    break;
                }
                j -= 1;
            }
            i += 1;
        }
        max_len
    }
}