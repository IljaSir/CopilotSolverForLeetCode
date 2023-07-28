impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut primes = vec![true; (n + 1) as usize];
        for i in 2..=n {
            if primes[i as usize] {
                let mut j = 2 * i;
                while j <= n {
                    primes[j as usize] = false;
                    j += i;
                }
            }
        }
        let mut prime_count = 0;
        for i in 2..=n {
            if primes[i as usize] {
                prime_count += 1;
            }
        }
        let mut result = 1;
        for i in 1..prime_count + 1 {
            result = (result * i) % 1_000_000_007;
        }
        for i in 1..(n - prime_count + 1) {
            result = (result * i) % 1_000_000_007;
        }
        result
    }
}