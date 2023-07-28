impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut primes = vec![true; (n + 1) as usize];
        primes[0] = false;
        primes[1] = false;
        let mut count = 0;
        for i in 2..=n {
            if primes[i as usize] {
                count += 1;
                let mut j = i * i;
                while j <= n {
                    primes[j as usize] = false;
                    j += i;
                }
            }
        }
        let not_primes = n - count;
        let mut res = 1;
        let modu = 1_000_000_007;
        for i in 1..=count {
            res = (res * i) % modu;
        }
        for i in 1..=not_primes {
            res = (res * i) % modu;
        }
        res
    }
}