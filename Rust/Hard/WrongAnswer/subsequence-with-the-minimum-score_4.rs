impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        let mut ret = 0;
        let mut i = 0;
        let mut j = 0;
        let mut n = 0;
        let mut m = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                if n > 0 {
                    ret += 1;
                }
                n = 0;
                m = 0;
                i += 1;
                j += 1;
            } else {
                n += 1;
                m += 1;
                i += 1;
            }
        }
        ret + m
    }
}