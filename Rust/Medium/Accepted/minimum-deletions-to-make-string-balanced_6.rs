impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut c = 0;
        let mut r = 0;
        for ch in s.chars() {
            if ch == 'b' {
                c += 1;
            } else {
                if c > 0 {
                    c -= 1;
                    r += 1;
                }
            }
        }
        r
    }
}