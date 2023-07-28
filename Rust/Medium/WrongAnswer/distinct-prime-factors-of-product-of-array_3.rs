impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
            }
        }
        let mut res = 0;
        let mut primes = vec![true; (max + 1) as usize];
        for i in 2..(max + 1) {
            if primes[i as usize] {
                let mut j = i;
                while j <= max {
                    primes[j as usize] = false;
                    j += i;
                }
                primes[i as usize] = true;
                let mut count = 0;
                for k in 0..nums.len() {
                    if nums[k] % i == 0 {
                        count += 1;
                    }
                }
                if count > 1 {
                    res += 1;
                }
            }
        }
        res
    }
}