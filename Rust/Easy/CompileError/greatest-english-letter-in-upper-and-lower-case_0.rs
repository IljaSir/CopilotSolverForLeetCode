impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut upper = vec![false; 26];
        let mut lower = vec![false; 26];
        for c in s.chars() {
            if c.is_uppercase() {
                upper[c as usize - 'A' as usize] = true;
            } else {
                lower[c as usize - 'a' as usize] = true;
            }
        }
        for i in (0..26).rev() {
            if upper[i] && lower[i] {
                return (i + 'A' as usize) as u8 as char;
            }
        }
        "".to_string()
    }
}