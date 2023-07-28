impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut s2t = vec![0; 256];
        let mut t2s = vec![0; 256];
        let s = s.as_bytes();
        let t = t.as_bytes();
        for i in 0..s.len() {
            if s2t[s[i] as usize] == 0 && t2s[t[i] as usize] == 0 {
                s2t[s[i] as usize] = t[i];
                t2s[t[i] as usize] = s[i];
            }
            if s2t[s[i] as usize] != t[i] || t2s[t[i] as usize] != s[i] {
                return false;
            }
        }
        true
    }
}