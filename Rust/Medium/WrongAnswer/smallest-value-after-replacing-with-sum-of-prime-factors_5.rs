impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        let mut primes = vec![2];
        for i in 3..=n {
            let mut is_prime = true;
            for p in &primes {
                if i % p == 0 {
                    is_prime = false;
                    break;
                }
            }
            if is_prime {
                primes.push(i);
            }
        }
        let mut sum = 0;
        for p in &primes {
            while n % p == 0 {
                sum += p;
                n /= p;
            }
        }
        if n > 1 {
            sum += n;
        }
        sum
    }
}