impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let mut s = s.chars();
        let mut t = t.chars();
        let mut c = s.next();
        while let Some(x) = t.next() {
            if Some(x) == c {
                c = s.next();
            }
        }
        c == None
    }
}