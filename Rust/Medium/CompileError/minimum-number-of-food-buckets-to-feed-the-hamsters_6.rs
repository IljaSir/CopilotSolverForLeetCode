impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut h = 0;
        let mut r = 0;
        for c in hamsters.chars() {
            if c == 'H' {
                h += 1;
            }
            r = r.max(h);
            if c == '.' {
                h = h.saturating_sub(1);
            }
        }
        r
    }
}