impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = t.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < s.len() {
            if s[i] == '#' {
                s.remove(i);
                if i > 0 {
                    s.remove(i - 1);
                    i -= 1;
                }
            } else {
                i += 1;
            }
        }
        i = 0;
        while i < t.len() {
            if t[i] == '#' {
                t.remove(i);
                if i > 0 {
                    t.remove(i - 1);
                    i -= 1;
                }
            } else {
                i += 1;
            }
        }
        s == t
    }
}