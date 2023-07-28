impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut s = s.as_bytes().to_vec();
        let mut t = t.as_bytes().to_vec();
        s.sort();
        t.sort();
        for i in 0..s.len() {
            if s[i] != t[i] {
                return t[i] as char;
            }
        }
        return t[t.len() - 1] as char;
    }
}