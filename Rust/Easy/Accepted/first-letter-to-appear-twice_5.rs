impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut v = vec![0; 26];
        for c in s.chars() {
            let i = (c as u8 - 'a' as u8) as usize;
            if v[i] == 1 {
                return c;
            }
            v[i] += 1;
        }
        'a'
    }
}