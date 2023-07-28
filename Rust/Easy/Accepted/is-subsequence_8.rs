impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let mut s = s.chars();
        let mut t = t.chars();
        let mut c = s.next();
        while let Some(a) = t.next() {
            if Some(a) == c {
                c = s.next();
            }
        }
        c.is_none()
    }
}