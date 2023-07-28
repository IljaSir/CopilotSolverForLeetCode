impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        let mut x = n;
        if x == 0 {
            return 1;
        }
        let mut res = 0;
        let mut i = 0;
        while x > 0 {
            if x & 1 == 0 {
                res += 1 << i;
            }
            x >>= 1;
            i += 1;
        }
        res
    }
}