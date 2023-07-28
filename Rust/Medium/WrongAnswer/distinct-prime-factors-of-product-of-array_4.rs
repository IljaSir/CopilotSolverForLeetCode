impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut max = 0;
        for i in &nums {
            if *i > max {
                max = *i;
            }
        }
        let mut primes = vec![true; max as usize + 1];
        primes[0] = false;
        primes[1] = false;
        for i in 2..=max {
            if primes[i as usize] {
                res += 1;
                let mut j = i;
                while j <= max {
                    primes[j as usize] = false;
                    j += i;
                }
            }
        }
        res
    }
}