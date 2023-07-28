impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut prev = n & 1;
        n >>= 1;
        while n > 0 {
            let cur = n & 1;
            if cur == prev {
                return false;
            }
            prev = cur;
            n >>= 1;
        }
        true
    }
}