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
        for num in nums {
            if num <= prev {
                let mut p = 2;
                while p < num {
                    if primes[p as usize] && num - p > prev {
                        break;
                    }
                    p += 1;
                }
                if p == num {
                    return false;
                }
            }
            prev = num;
        }
        true
    }
}