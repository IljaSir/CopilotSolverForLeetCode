impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut last_bit = n & 1;
        let mut n = n >> 1;
        while n != 0 {
            if (n & 1) == last_bit {
                return false;
            }
            last_bit = n & 1;
            n = n >> 1;
        }
        true
    }
}