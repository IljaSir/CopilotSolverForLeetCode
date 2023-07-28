impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        let mut i = s.len() - 1;
        let mut j = t.len() - 1;
        let mut skip_s = 0;
        let mut skip_t = 0;
        while i >= 0 || j >= 0 {
            while i >= 0 {
                if s[i] == '#' {
                    skip_s += 1;
                    i -= 1;
                } else if skip_s > 0 {
                    skip_s -= 1;
                    i -= 1;
                } else {
                    break;
                }
            }
            while j >= 0 {
                if t[j] == '#' {
                    skip_t += 1;
                    j -= 1;
                } else if skip_t > 0 {
                    skip_t -= 1;
                    j -= 1;
                } else {
                    break;
                }
            }
            if i >= 0 && j >= 0 && s[i] != t[j] {
                return false;
            }
            if (i >= 0) != (j >= 0) {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        return true;
    }
}