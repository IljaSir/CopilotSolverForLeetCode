impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut buckets = 0;
        let mut h = 0;
        for c in hamsters.chars() {
            if c == 'H' {
                if h == 0 {
                    buckets += 1;
                }
                h += 1;
            } else {
                if h > 0 {
                    h -= 1;
                }
            }
        }
        if h > 0 {
            -1
        } else {
            buckets
        }
    }
}