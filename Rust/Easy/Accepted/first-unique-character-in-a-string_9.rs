impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        
        let mut char_count = [0; 26];
        for c in s.chars() {
            char_count[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for (i, c) in s.chars().enumerate() {
            let count = char_count[(c as u8 - 'a' as u8) as usize];
            if count == 1 {
                return i as i32;
            }
        }
        -1
    }
}