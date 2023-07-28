impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut n = 0;
        let mut s = String::new();
        let mut v = Vec::new();
        for c in word.chars() {
            if c.is_numeric() {
                s.push(c);
            } else {
                if !s.is_empty() {
                    v.push(s);
                    s = String::new();
                }
            }
        }
        if !s.is_empty() {
            v.push(s);
        }
        let mut v1 = Vec::new();
        for s in v {
            let mut s1 = String::new();
            for c in s.chars() {
                if c != '0' {
                    s1.push(c);
                }
            }
            if !s1.is_empty() {
                v1.push(s1);
            }
        }
        let mut v2 = Vec::new();
        for s in v1 {
            if !v2.contains(&s) {
                v2.push(s);
                n += 1;
            }
        }
        n
    }
}