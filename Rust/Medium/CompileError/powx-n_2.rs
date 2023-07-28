impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        if x == 0.0 {
            return 0.0;
        }
        if n == 0 {
            return 1.0;
        }
        if n == 1 {
            return x;
        }
        if n == -1 {
            return 1.0 / x;
        }
        let mut n = n as i64;
        if n < 0 {
            n = -n;
            return Solution::my_pow(1.0 / x, n as i32);
        }
        let mut half = Solution::my_pow(x, n / 2);
        if n % 2 == 0 {
            return half * half;
        }
        half * half * x
    }
}