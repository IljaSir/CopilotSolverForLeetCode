impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        
        let mut x = x;
        let mut r = 0;
        for _ in 0..32 {
            r <<= 1;
            r += x & 1;
            x >>= 1;
        }
        r
    }
}