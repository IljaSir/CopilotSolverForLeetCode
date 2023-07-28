impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        if n == 0 {
            return 1.0;
        }
        if x == 0.0 {
            return 0.0;
        }
        let mut n = n;
        let mut x = x;
        if n < 0 {
            n = -n;
            x = 1.0 / x;
        }
        let mut ret = 1.0;
        while n > 0 {
            if n & 1 == 1 {
                ret *= x;
            }
            x *= x;
            n >>= 1;
        }
        ret
    }
}