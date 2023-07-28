impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut letters = vec![0; 26];
        for c in s.chars() {
            let i = c as usize - 'a' as usize;
            if letters[i] == 1 {
                return c;
            }
            letters[i] += 1;
        }
        ' '
    }
}