impl Solution {
    pub fn find_integers(n: i32) -> i32 {
        
        let mut n = n;
        let mut ans = 0;
        let mut a = 0;
        let mut b = 1;
        while n > 0 {
            if n & 1 > 0 && n & 2 > 0 {
                ans = a + b;
                a = b;
            } else {
                ans += b;
                a = 0;
            }
            b += a;
            n >>= 1;
        }
        ans
    }
}