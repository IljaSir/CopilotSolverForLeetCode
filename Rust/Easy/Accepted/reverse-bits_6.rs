impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        
        let mut result = 0;
        let mut x = x;
        for _ in 0..32 {
            result = result << 1;
            result = result | (x & 1);
            x = x >> 1;
        }
        result
    }
}