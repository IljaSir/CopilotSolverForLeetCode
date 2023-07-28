impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut last_bit = n & 1;
        n >>= 1;
        while n > 0 {
            if last_bit == (n & 1) {
                return false;
            }
            last_bit = n & 1;
            n >>= 1;
        }
        true
    }
}