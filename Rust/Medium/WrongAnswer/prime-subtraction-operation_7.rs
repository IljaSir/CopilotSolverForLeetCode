impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let mut primes = vec![true; 1000];
        primes[0] = false;
        primes[1] = false;
        for i in 2..1000 {
            if primes[i] {
                let mut j = i * i;
                while j < 1000 {
                    primes[j] = false;
                    j += i;
                }
            }
        }
        let mut prev = 0;
        for &num in nums.iter() {
            if num <= prev {
                let mut found = false;
                for i in (prev + 1..num).rev() {
                    if primes[i as usize] {
                        prev = i;
                        found = true;
                        break;
                    }
                }
                if !found {
                    return false;
                }
            } else {
                prev = num;
            }
        }
        true
    }
}