impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        if n == 0 {
            return 1.0;
        }
        if n == 1 {
            return x;
        }
        if n == -1 {
            return 1.0 / x;
        }
        let mut y = Solution::my_pow(x, n / 2);
        y *= y;
        if n % 2 == 1 {
            y *= x;
        }
        if n % 2 == -1 {
            y /= x;
        }
        y
    }
}