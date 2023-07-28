impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        
        let mut weight = 0;
        let mut n = n;
        while n > 0 {
            if n & 0x01 == 1 {
                weight += 1;
            }
            n = n >> 1;
        }
        weight
    }
}