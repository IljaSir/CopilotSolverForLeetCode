impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s1 = s.clone();
        let mut t1 = t.clone();
        let mut i = 0;
        while i < s1.len() {
            if s1.chars().nth(i) == Some('#') {
                if i > 0 {
                    s1.remove(i);
                    s1.remove(i-1);
                    i -= 1;
                } else {
                    s1.remove(i);
                }
            } else {
                i += 1;
            }
        }
        i = 0;
        while i < t1.len() {
            if t1.chars().nth(i) == Some('#') {
                if i > 0 {
                    t1.remove(i);
                    t1.remove(i-1);
                    i -= 1;
                } else {
                    t1.remove(i);
                }
            } else {
                i += 1;
            }
        }
        s1 == t1
    }
}