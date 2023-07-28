impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut primes = 0;
        let mut composites = 0;
        let mut i = 1;
        while i <= n {
            if Self::is_prime(i) {
                primes += 1;
            } else {
                composites += 1;
            }
            i += 1;
        }
        let mut result = 1;
        let mut i = 1;
        while i <= primes {
            result = (result * i) % 1_000_000_007;
            i += 1;
        }
        let mut i = 1;
        while i <= composites {
            result = (result * i) % 1_000_000_007;
            i += 1;
        }
        result
    }
    fn is_prime(n: i32) -> bool {
        if n <= 1 {
            return false;
        }
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 1;
        }
        true
    }
}