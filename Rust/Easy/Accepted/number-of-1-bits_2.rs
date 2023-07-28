impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        
        let mut count = 0;
        let mut n = n;
        for _ in 0..32 {
            if n & 1 == 1 {
                count += 1;
            }
            n >>= 1;
        }
        count
    }
}