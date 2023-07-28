impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut last = n & 1;
        n >>= 1;
        while n > 0 {
            let cur = n & 1;
            if cur == last {
                return false;
            }
            n >>= 1;
            last = cur;
        }
        true
    }
}