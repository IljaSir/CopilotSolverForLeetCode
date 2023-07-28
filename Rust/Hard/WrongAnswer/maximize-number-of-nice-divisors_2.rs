impl Solution {
    pub fn max_nice_divisors(prime_factors: i32) -> i32 {
        
        let m = 1000000007;
        if prime_factors <= 3 {
            return prime_factors;
        }
        let a = prime_factors / 3;
        let b = prime_factors % 3;
        let mut res = 1;
        for _ in 0..a-1 {
            res = (res * 3) % m;
        }
        if b == 0 {
            res = (res * 3) % m;
        } else if b == 1 {
            res = (res * 4) % m;
        } else {
            res = (res * 6) % m;
        }
        res
    }
}