impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s = s;
        let mut t = t;
        let mut i = 0;
        while i < s.len() {
            if s.as_bytes()[i] == b'#' {
                if i != 0 {
                    s.remove(i);
                    s.remove(i-1);
                    i -= 1;
                } else {
                    s.remove(i);
                }
            } else {
                i += 1;
            }
        }
        i = 0;
        while i < t.len() {
            if t.as_bytes()[i] == b'#' {
                if i != 0 {
                    t.remove(i);
                    t.remove(i-1);
                    i -= 1;
                } else {
                    t.remove(i);
                }
            } else {
                i += 1;
            }
        }
        s == t
    }
}