impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        if n == 0 {
            return 1.0;
        }
        let mut n = n;
        let mut x = x;
        if n < 0 {
            n = -n;
            x = 1.0 / x;
        }
        let mut ans = 1.0;
        let mut cur = x;
        for i in (0..32).rev() {
            if n & (1 << i) != 0 {
                ans *= cur;
            }
            cur *= cur;
        }
        ans
    }
}