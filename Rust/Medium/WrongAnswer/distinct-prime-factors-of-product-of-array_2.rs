impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut primes = vec![];
        for i in 2..=1000 {
            if primes.iter().all(|&x| i % x != 0) {
                primes.push(i);
            }
        }
        let mut factors = vec![0; 1001];
        for i in 2..=1000 {
            let mut n = i;
            for &p in primes.iter() {
                if n == 1 { break; }
                if n % p == 0 {
                    factors[i] += 1;
                    n /= p;
                    while n % p == 0 {
                        n /= p;
                    }
                }
            }
        }
        let mut res = 0;
        for &n in nums.iter() {
            res += factors[n as usize];
        }
        res
    }
}