impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut primes = vec![];
        for i in left..=right {
            if Self::is_prime(i) {
                primes.push(i);
            }
        }
        if primes.len() < 2 {
            return vec![-1, -1];
        }
        let mut min = i32::MAX;
        let mut res = vec![];
        for i in 0..primes.len() - 1 {
            let diff = primes[i + 1] - primes[i];
            if diff < min {
                min = diff;
                res = vec![primes[i], primes[i + 1]];
            }
        }
        res
    }
    fn is_prime(n: i32) -> bool {
        if n == 1 {
            return false;
        }
        for i in 2..=n / 2 {
            if n % i == 0 {
                return false;
            }
        }
        true
    }
}