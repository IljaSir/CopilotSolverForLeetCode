impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let s = s.into_bytes();
        let s_len = s.len();
        for (i, v) in s.iter().enumerate() {
            if i < s_len/2 {
                a += match v {
                    b'a' | b'e' | b'i' | b'o' | b'u' | b'A' | b'E' | b'I' | b'O' | b'U' => 1,
                    _ => 0,
                };
            } else {
                b += match v {
                    b'a' | b'e' | b'i' | b'o' | b'u' | b'A' | b'E' | b'I' | b'O' | b'U' => 1,
                    _ => 0,
                };
            }
        }
        a == b
    }
}