impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut primes = vec![true; (n + 1) as usize];
        primes[0] = false;
        primes[1] = false;
        for i in 2..(n + 1) as usize {
            if primes[i] {
                let mut j = i + i;
                while j < (n + 1) as usize {
                    primes[j] = false;
                    j += i;
                }
            }
        }
        let mut prime_count = 0;
        for i in 0..(n + 1) as usize {
            if primes[i] {
                prime_count += 1;
            }
        }
        let mut non_prime_count = n - prime_count;
        let mut result = 1;
        let mut mod_num = 1_000_000_007;
        while prime_count > 0 {
            result = (result * prime_count) % mod_num;
            prime_count -= 1;
        }
        while non_prime_count > 0 {
            result = (result * non_prime_count) % mod_num;
            non_prime_count -= 1;
        }
        result
    }
}