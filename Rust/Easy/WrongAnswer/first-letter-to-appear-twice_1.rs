impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut chars: Vec<char> = s.chars().collect();
        chars.sort();
        for i in 0..chars.len() - 1 {
            if chars[i] == chars[i + 1] {
                return chars[i];
            }
        }
        return ' ';
    }
}