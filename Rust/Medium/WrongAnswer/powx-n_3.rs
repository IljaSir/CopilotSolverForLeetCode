impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        let mut x = x;
        let mut n = n;
        if n < 0 {
            n = -n;
            x = 1.0 / x;
        }
        let mut ans = 1.0;
        let mut cur = x;
        let mut i = n;
        while i > 0 {
            if (i & 1) == 1 {
                ans *= cur;
            }
            cur *= cur;
            i >>= 1;
        }
        ans
    }
}