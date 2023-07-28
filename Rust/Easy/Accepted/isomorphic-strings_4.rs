impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut s2t = [0; 128];
        let mut t2s = [0; 128];
        let s = s.into_bytes();
        let t = t.into_bytes();
        for i in 0..s.len() {
            if s2t[s[i] as usize] == 0 && t2s[t[i] as usize] == 0 {
                s2t[s[i] as usize] = t[i];
                t2s[t[i] as usize] = s[i];
            } else if s2t[s[i] as usize] != t[i] || t2s[t[i] as usize] != s[i] {
                return false;
            }
        }
        true
    }
}