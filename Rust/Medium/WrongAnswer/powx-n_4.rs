impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        let mut x = x;
        let mut n = n;
        if n < 0 {
            x = 1.0 / x;
            n = -n;
        }
        let mut res = 1.0;
        let mut curr = x;
        for i in (0..32).rev() {
            if (n >> i) & 1 == 1 {
                res *= curr;
            }
            curr *= curr;
        }
        res
    }
}