impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        

        if n == 0 {
            return 1.0;
        }
        if n < 0 {
            return 1.0 / Self::my_pow(x, -n);
        }
        if n % 2 == 0 {
            return Self::my_pow(x * x, n / 2);
        }
        return x * Self::my_pow(x, n - 1);
    }
}