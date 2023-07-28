impl Solution {
    pub fn max_nice_divisors(prime_factors: i32) -> i32 {
        
        if prime_factors <= 3 {
            return prime_factors;
        }
        let mut p = prime_factors;
        let mut r = 1;
        while p > 4 {
            r = (r * 3) % 1000000007;
            p -= 3;
        }
        (r * p) % 1000000007
    }
}