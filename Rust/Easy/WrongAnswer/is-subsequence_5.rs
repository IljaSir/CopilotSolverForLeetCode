impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let mut s = s.chars();
        for c in t.chars() {
            if let Some(sc) = s.next() {
                if sc != c {
                    return false;
                }
            }
        }
        s.next().is_none()
    }
}