impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
        s.sort();
        t.sort();
        for i in 0..t.len() {
            if s.get(i) != t.get(i) {
                return t[i] as char;
            }
        }
        return ' ';
    }
}