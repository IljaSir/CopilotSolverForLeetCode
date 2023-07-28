impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        if n == 0 {
            return 1;
        }
        let mut n = n;
        let mut res = 0;
        let mut mask = 1;
        while n > 0 {
            if n & 1 == 0 {
                res |= mask;
            }
            mask <<= 1;
            n >>= 1;
        }
        res
    }
}