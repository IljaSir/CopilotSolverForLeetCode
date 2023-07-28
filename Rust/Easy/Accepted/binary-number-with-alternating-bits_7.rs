impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut last = n & 1;
        n >>= 1;
        while n > 0 {
            let t = n & 1;
            if t == last {
                return false;
            }
            last = t;
            n >>= 1;
        }
        true
    }
}