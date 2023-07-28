impl Solution {
    pub fn possibly_equals(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            true
        } else if s1.len() != s2.len() {
            false
        } else {
            let mut i = 0;
            let mut j = 0;
            let mut c1 = 0;
            let mut c2 = 0;
            while i < s1.len() && j < s2.len() {
                if s1.as_bytes()[i] == s2.as_bytes()[j] {
                    i += 1;
                    j += 1;
                    continue;
                }
                if s1.as_bytes()[i] >= b'1' && s1.as_bytes()[i] <= b'9' {
                    c1 = s1.as_bytes()[i] - b'0';
                    i += 1;
                    while i < s1.len() && s1.as_bytes()[i] >= b'0' && s1.as_bytes()[i] <= b'9' {
                        c1 = c1 * 10 + (s1.as_bytes()[i] - b'0');
                        i += 1;
                    }
                }
                if s2.as_bytes()[j] >= b'1' && s2.as_bytes()[j] <= b'9' {
                    c2 = s2.as_bytes()[j] - b'0';
                    j += 1;
                    while j < s2.len() && s2.as_bytes()[j] >= b'0' && s2.as_bytes()[j] <= b'9' {
                        c2 = c2 * 10 + (s2.as_bytes()[j] - b'0');
                        j += 1;
                    }
                }
                if c1 != c2 {
                    return false;
                }
                c1 = 0;
                c2 = 0;
            }
            true
        }
    }
}