impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut chars = [0; 26];
        for (i, c) in s.bytes().enumerate() {
            let c = c - b'a';
            if chars[c as usize] == 0 {
                chars[c as usize] = i as i32 + 1;
            } else {
                chars[c as usize] = i as i32 - chars[c as usize] + 1;
            }
        }
        *chars.iter().max().unwrap_or(&-1)
    }
}