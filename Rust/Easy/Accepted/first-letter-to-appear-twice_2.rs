impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut seen = vec![false; 26];
        for c in s.chars() {
            let idx = (c as u8 - 'a' as u8) as usize;
            if seen[idx] {
                return c;
            }
            seen[idx] = true;
        }
        ' '
    }
}