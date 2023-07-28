impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        if n == 0 { return 1; }
        let mut i = 0;
        let mut m = n;
        while m > 0 {
            m >>= 1;
            i += 1;
        }
        let mask = (1 << i) - 1;
        n ^ mask
    }
}