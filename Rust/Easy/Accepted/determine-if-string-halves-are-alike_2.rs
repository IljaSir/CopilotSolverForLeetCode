impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        for c in s.chars() {
            if i < s.len() / 2 {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' {
                    a += 1;
                }
            } else {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' {
                    b += 1;
                }
            }
            i += 1;
        }
        return a == b;
    }
}