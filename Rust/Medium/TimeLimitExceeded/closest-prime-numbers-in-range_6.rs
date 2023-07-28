impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans = vec![-1, -1];
        let mut min = right - left;
        for i in (left..=right).filter(|&x| Self::is_prime(x)) {
            for j in (left..=right).filter(|&x| Self::is_prime(x)) {
                if i == j {
                    continue;
                }
                if (j - i).abs() < min {
                    ans = vec![i, j];
                    min = (j - i).abs();
                }
            }
        }
        ans
    }
    fn is_prime(n: i32) -> bool {
        if n < 2 {
            return false;
        }
        for i in 2..=(n as f64).sqrt() as i32 {
            if n % i == 0 {
                return false;
            }
        }
        true
    }
}