impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        
        let mut x = x;
        let mut r = 0;
        for _ in 0..32 {
            r = (r << 1) + (x & 1);
            x >>= 1;
        }
        r
    }
}