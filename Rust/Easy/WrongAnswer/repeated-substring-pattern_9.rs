impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let mut s = s;
        let mut l = s.len();
        while l > 1 {
            if s.len() % l == 0 {
                let mut p = s.clone();
                p.truncate(l);
                let mut i = l;
                while i < s.len() {
                    if s[i..(i + l)] != p {
                        break;
                    }
                    i += l;
                }
                if i == s.len() {
                    return true;
                }
            }
            l -= 1;
        }
        false
    }
}