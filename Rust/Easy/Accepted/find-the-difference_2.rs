impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
        s.sort();
        t.sort();
        for i in 0..s.len() {
            if s[i] != t[i] {
                return t[i] as char;
            }
        }
        t[s.len()] as char
    }
}