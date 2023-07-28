impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut mapping = [0; 256];
        let mut visited = [false; 256];
        let s = s.as_bytes();
        let t = t.as_bytes();
        for i in 0..s.len() {
            if mapping[s[i] as usize] == 0 {
                if visited[t[i] as usize] {
                    return false;
                }
                mapping[s[i] as usize] = t[i] as usize;
                visited[t[i] as usize] = true;
            } else if mapping[s[i] as usize] != t[i] as usize {
                return false;
            }
        }
        true
    }
}