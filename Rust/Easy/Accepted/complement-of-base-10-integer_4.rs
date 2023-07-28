impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        if n == 0 {
            return 1;
        }
        let mut n = n;
        let mut res = 0;
        let mut i = 0;
        while n != 0 {
            let bit = n & 1;
            if bit == 0 {
                res += 1 << i;
            }
            n >>= 1;
            i += 1;
        }
        res
    }
}