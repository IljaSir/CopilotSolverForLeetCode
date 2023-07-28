impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let mut count = 0;
        let s = s.as_bytes();
        let t = t.as_bytes();
        for i in 0..s.len() {
            for j in 0..t.len() {
                let mut diff = 0;
                for k in 0..(s.len() - i).min(t.len() - j) {
                    if s[i + k] != t[j + k] {
                        diff += 1;
                    }
                    if diff == 2 {
                        break;
                    }
                    if diff == 1 {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}