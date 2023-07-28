impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut seen: [bool; 26] = [false; 26];
        for c in s.chars() {
            let idx = (c as u8 - 97) as usize;
            if seen[idx] {
                return c;
            } else {
                seen[idx] = true;
            }
        }
        ' '
    }
}