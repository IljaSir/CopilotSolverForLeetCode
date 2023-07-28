impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        
        let mut v = vec![0; 26];
        for c in s.chars() {
            v[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for (i, c) in s.chars().enumerate() {
            if v[(c as u8 - 'a' as u8) as usize] == 1 {
                return i as i32;
            }
        }
        return -1;
    }
}