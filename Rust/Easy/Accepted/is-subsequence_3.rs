impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let n = s.len();
        let m = t.len();
        let mut i = 0;
        let mut j = 0;
        while i < n && j < m {
            if s.as_bytes()[i] == t.as_bytes()[j] {
                i += 1;
            }
            j += 1;
        }
        i == n
    }
}