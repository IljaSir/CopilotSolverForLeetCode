impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut primes = vec![];
        let mut i = left;
        while i <= right {
            if Self::is_prime(i) {
                primes.push(i);
            }
            i += 1;
        }
        if primes.len() < 2 {
            return vec![-1, -1];
        }
        let mut min_diff = i32::MAX;
        let mut min_diff_idx = 0;
        let mut idx = 1;
        while idx < primes.len() {
            let diff = primes[idx] - primes[idx - 1];
            if diff < min_diff {
                min_diff = diff;
                min_diff_idx = idx - 1;
            }
            idx += 1;
        }
        vec![primes[min_diff_idx], primes[min_diff_idx + 1]]
    }
    fn is_prime(n: i32) -> bool {
        if n == 2 || n == 3 {
            return true;
        }
        if n < 2 || n % 2 == 0 {
            return false;
        }
        let mut i = 3;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 2;
        }
        true
    }
}