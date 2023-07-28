impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for num in nums.iter() {
            if *num > max {
                max = *num;
            }
        }
        let mut factors = vec![0; max as usize + 1];
        for num in nums.iter() {
            let mut n = *num as usize;
            for i in 2..=n {
                if n % i == 0 {
                    factors[i] += 1;
                    while n % i == 0 {
                        n /= i;
                    }
                }
            }
        }
        let mut result = 0;
        for num in factors.iter() {
            if *num > 0 {
                result += 1;
            }
        }
        result
    }
}