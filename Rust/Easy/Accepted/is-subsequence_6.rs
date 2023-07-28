impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let mut s = s.chars();
        let mut t = t.chars();
        let mut s_next = s.next();
        let mut t_next = t.next();
        while s_next.is_some() && t_next.is_some() {
            if s_next == t_next {
                s_next = s.next();
            }
            t_next = t.next();
        }
        s_next.is_none()
    }
}