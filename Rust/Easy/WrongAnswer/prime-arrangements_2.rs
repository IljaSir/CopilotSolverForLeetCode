impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let m = 1_000_000_007;
        let mut primes = vec![true; n as usize + 1];
        primes[0] = false;
        primes[1] = false;
        for i in 2..=n as usize {
            if primes[i] {
                let mut j = 2;
                while i * j <= n as usize {
                    primes[i * j] = false;
                    j += 1;
                }
            }
        }
        let mut n_primes = 0;
        for i in 2..=n as usize {
            if primes[i] {
                n_primes += 1;
            }
        }
        let mut ans = 1;
        for i in 1..=n_primes {
            ans = ans * i % m;
        }
        for i in 1..=(n - n_primes) {
            ans = ans * i % m;
        }
        ans
    }
}