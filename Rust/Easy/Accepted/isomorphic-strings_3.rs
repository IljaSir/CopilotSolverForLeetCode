impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut m1 = vec![0; 256];
        let mut m2 = vec![0; 256];
        let mut i = 0;
        while i < s.len() {
            if m1[s.as_bytes()[i] as usize] != m2[t.as_bytes()[i] as usize] {
                return false;
            }
            m1[s.as_bytes()[i] as usize] = i + 1;
            m2[t.as_bytes()[i] as usize] = i + 1;
            i += 1;
        }
        true
    }
}