impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        
        let mut n = x;
        let mut ret = 0;
        for _i in 0..32 {
            ret <<= 1;
            ret |= n & 1;
            n >>= 1;
        }
        ret
    }
}