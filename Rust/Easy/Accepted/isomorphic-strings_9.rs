impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        if s.len() != t.len() {
            return false;
        }
        let (mut s, mut t) = (s.into_bytes(), t.into_bytes());
        let mut map = vec![0; 256];
        let mut set = vec![false; 256];
        for i in 0..s.len() {
            if map[s[i] as usize] == 0 {
                if set[t[i] as usize] {
                    return false;
                }
                map[s[i] as usize] = t[i] as usize;
                set[t[i] as usize] = true;
            } else {
                if map[s[i] as usize] != t[i] as usize {
                    return false;
                }
            }
        }
        true
    }
}