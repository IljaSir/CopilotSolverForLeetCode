impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        for c in s.chars() {
            if i < s.len() / 2 {
                if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
                    a += 1;
                }
            } else {
                if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
                    b += 1;
                }
            }
            i += 1;
        }
        a == b
    }
}