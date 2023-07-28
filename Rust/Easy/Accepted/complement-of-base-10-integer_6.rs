impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        if n == 0 {
            return 1;
        }
        let mut n = n;
        let mut ans = 0;
        let mut i = 0;
        while n > 0 {
            ans += (((n & 1) + 1) % 2) << i;
            n >>= 1;
            i += 1;
        }
        ans
    }
}