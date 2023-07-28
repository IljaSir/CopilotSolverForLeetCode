impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut t: Vec<char> = t.chars().collect();
        let mut s_index = s.len() - 1;
        let mut t_index = t.len() - 1;
        while s_index < s.len() && t_index < t.len() {
            let mut s_count = 0;
            let mut t_count = 0;
            while s_index < s.len() && (s[s_index] == '#' || s_count > 0) {
                if s[s_index] == '#' {
                    s_count += 1;
                } else if s_count > 0 {
                    s_count -= 1;
                }
                s_index -= 1;
            }
            while t_index < t.len() && (t[t_index] == '#' || t_count > 0) {
                if t[t_index] == '#' {
                    t_count += 1;
                } else if t_count > 0 {
                    t_count -= 1;
                }
                t_index -= 1;
            }
            if s_index < s.len() && t_index < t.len() && s[s_index] != t[t_index] {
                return false;
            }
            s_index -= 1;
            t_index -= 1;
        }
        s_index < s.len() || t_index < t.len()
    }
}